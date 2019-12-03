package servlets;

import com.codahale.metrics.*;
import com.codahale.metrics.Timer;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.entity.Location;
import com.lo54.lo54ecole.service.CourseSessionService;
import com.lo54.lo54ecole.service.LocationService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@WebServlet( name="CatalogServlet",
        urlPatterns = {"", "/", "/catalog"}, loadOnStartup = 1 )
public class CatalogServlet extends HttpServlet {

    CourseSessionService courseSessionService = new CourseSessionService();
    LocationService locationService = new LocationService();
    MetricRegistry metricRegistry;
    private Meter meter;
    private Timer timer;

    public void init() throws ServletException
    {
        metricRegistry = new MetricRegistry();
        metricRegistry.register("gc", new GarbageCollectorMetricSet());
        metricRegistry.register("memory", new MemoryUsageGaugeSet());
        metricRegistry.register("threads", new ThreadStatesGaugeSet());

        final Graphite graphite = new Graphite(
                new InetSocketAddress("localhost", 2003));
        final GraphiteReporter reporter = GraphiteReporter.forRegistry(metricRegistry)
                .prefixedWith("lo54")
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .build(graphite);
        reporter.start(5, TimeUnit.SECONDS);
    }


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        //timer
        timer = metricRegistry.timer("timer_get_catalog");
        final Timer.Context context = timer.time();
        //meter
        meter = metricRegistry.meter("meter_get_catalog");
        meter.mark();



        //get all location
        List<Location> listLocation = locationService.getAllLocation();

        String name = request.getParameter("name");
        Date date = null;
        try {
            if(request.getParameter("date")!=null)
                date = new SimpleDateFormat("yyyy-MM-dd").
                        parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String location = request.getParameter("location");

        //get list courseSession
        List<CourseSession> listCourseSession = null;
        if (name!=null)
            listCourseSession = courseSessionService.
                getCourseSessionByTitle(name);
        else if (date!=null)
            listCourseSession = courseSessionService.
                getCourseSessionByDate(date);
        else if(location!=null)
            listCourseSession = courseSessionService.
                getCourseSessionByLocation(location);
        else
            listCourseSession = courseSessionService.getAll();

        //set attributes for jsp
        request.setAttribute("listCourseSession", listCourseSession);
        request.setAttribute("listLocation", listLocation);
        try {
            this.getServletContext().
                    getRequestDispatcher("/WEB-INF/catalog.jsp").
                    forward(request, response);
        }finally {
            context.stop();
        }
    }

}
