package servlets;


import com.lo54.lo54ecole.entity.Client;
import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.service.ClientService;
import com.lo54.lo54ecole.service.CourseSessionService;
import com.lo54.lo54ecole.service.LocationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="InscriptionServlet", urlPatterns = {"/inscription", "/inscription/*"})
public class InscriptionServlet extends HttpServlet {

    CourseSessionService courseSessionService;
    ClientService clientService;

    public void init() {
        this.courseSessionService = new CourseSessionService();
        this.clientService = new ClientService();
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        String course_session = request.getParameter("cs");
        if (course_session==null || course_session.equals(""))
            request.setAttribute("courseSession", null);
        else{
            CourseSession courseSession = courseSessionService.
                    getCourseSessionById(Integer.parseInt(course_session));
            request.setAttribute("courseSession", courseSession);

            int nombreInscrit = clientService.
                    getCountClientByCourseSession(courseSession);
            request.setAttribute("nombreInscrit", nombreInscrit);
        }

        this.getServletContext().
                getRequestDispatcher( "/WEB-INF/inscription.jsp" ).
                forward( request, response );

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //get parameter
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int courseSessionId = Integer.parseInt(
                request.getParameter("courseSession"));

        //save client
        CourseSession courseSession = courseSessionService.
                                        getCourseSessionById(courseSessionId);
        Boolean inscriptionValide;
        try {
            Client client = new Client(lastname,
                    firstname,
                    address,
                    phone,
                    email,
                    courseSession);
            clientService.saveClient(client);
            inscriptionValide = true;
        }catch (Exception e){
            inscriptionValide = false;
        }

        //set attributes
        request.setAttribute("inscriptionValide", inscriptionValide);
        request.setAttribute("courseSession", courseSession);
        this.getServletContext().
                getRequestDispatcher( "/WEB-INF/inscriptionValide.jsp" ).
                forward( request, response );
    }

}
