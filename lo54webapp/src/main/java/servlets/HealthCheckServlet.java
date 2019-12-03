package servlets;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.entity.Location;
import com.lo54.lo54ecole.healthCheck.DatabaseHealthCheck;
import com.lo54.lo54ecole.service.CourseSessionService;
import com.lo54.lo54ecole.service.LocationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@WebServlet( name="HealthCheckServlet", urlPatterns = {"/healthcheck"})
public class HealthCheckServlet extends HttpServlet {

    HealthCheckRegistry healthChecks;

    public void init()
    {
        healthChecks = new HealthCheckRegistry();
        healthChecks.register("database", new DatabaseHealthCheck());
    }


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> listResponse = new ArrayList<>();
        final Map<String, HealthCheck.Result> results = healthChecks.runHealthChecks();
        for (Map.Entry<String, HealthCheck.Result> entry : results.entrySet()) {
            if (entry.getValue().isHealthy()) {
                listResponse.add(entry.getKey() + " is healthy");
            } else {
                listResponse.add(entry.getKey() + " is UNHEALTHY: " + entry.getValue().getMessage());
                final Throwable e = entry.getValue().getError();
                if (e != null) {
                    e.printStackTrace();
                }
            }
        }


        //set attributes for jsp
        request.setAttribute("listResponse", listResponse);
        this.getServletContext().
                getRequestDispatcher("/WEB-INF/healthCheck.jsp").
                forward(request, response);

    }

}
