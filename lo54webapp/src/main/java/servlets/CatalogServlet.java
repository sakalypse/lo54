package servlets;

import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.entity.Location;
import com.lo54.lo54ecole.service.CourseSessionService;
import com.lo54.lo54ecole.service.LocationService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet( name="CatalogServlet", urlPatterns = {"/catalog"} )
public class CatalogServlet extends HttpServlet {

    CourseSessionService courseSessionService = new CourseSessionService();
    LocationService locationService = new LocationService();

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
