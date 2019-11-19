package servlets;

import com.codahale.metrics.*;
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

@WebServlet( name="CatalogServlet", urlPatterns = {"", "/", "/catalog"}, loadOnStartup = 1 )
public class CatalogServlet extends HttpServlet {

    CourseSessionService courseSessionService = new CourseSessionService();
    LocationService locationService = new LocationService();


    public void init() throws ServletException
    {
        MetricRegistry metricRegistry = new MetricRegistry();
        metricRegistry.register("gc", new GarbageCollectorMetricSet());
        metricRegistry.register("memory", new MemoryUsageGaugeSet());
        metricRegistry.register("threads", new ThreadStatesGaugeSet());

        Meter meter = metricRegistry.meter("meter");
        meter.mark();
        meter.mark(200);
        Histogram histogram = metricRegistry.histogram("histogram");
        histogram.update(12);
        histogram.update(17);
        Counter counter = metricRegistry.counter("counter");
        counter.inc();
        counter.dec();

        ConsoleReporter consoleReporter = ConsoleReporter.forRegistry(metricRegistry).build();
        consoleReporter.start(5, TimeUnit.MICROSECONDS);
        consoleReporter.report();

        final Graphite graphite = new Graphite(new InetSocketAddress("localhost", 2003));
        final GraphiteReporter reporter = GraphiteReporter.forRegistry(metricRegistry)
                .prefixedWith("prefix")
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .build(graphite);
        reporter.start(5, TimeUnit.SECONDS);
    }


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
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
        this.getServletContext().
                getRequestDispatcher( "/WEB-INF/catalog.jsp" ).
                forward( request, response );
    }

}
