package servlets;

import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.service.CourseSessionService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet( name="CatalogServlet", urlPatterns = {"/catalog"} )
public class CatalogServlet extends HttpServlet {

    CourseSessionService courseSessionService = new CourseSessionService();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("searchAction");

        List<CourseSession> listCourseSession = null;

        if (action!=null){
            switch (action) {
                case "searchByTitle":
                    listCourseSession = courseSessionService.
                            getCourseSessionByTitle(
                                    request.getParameter("searchValue"));
                    break;
                case "searchByDate":
                    listCourseSession = courseSessionService.
                            getCourseSessionByDate(
                                    request.getParameter("searchValue"));
                    break;
                case "searchByLocation":
                    listCourseSession = courseSessionService.
                            getCourseSessionByLocation(
                                    request.getParameter("searchValue"));
                    break;
            }
        }else{
            listCourseSession = courseSessionService.getAll();
        }


        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Index</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("Hello World");
        for(CourseSession cs : listCourseSession){
            out.println(cs.toString()+"<br/>");
        }
        out.println("</BODY>");
        out.println("</HTML>");
    }

}
