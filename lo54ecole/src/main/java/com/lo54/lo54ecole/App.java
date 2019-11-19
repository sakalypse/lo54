package com.lo54.lo54ecole;
import com.lo54.lo54ecole.entity.Course;
import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.entity.Location;
import com.lo54.lo54ecole.repository.CourseDAO;
import com.lo54.lo54ecole.repository.CourseSessionDAO;
import com.lo54.lo54ecole.repository.LocationDAO;
import com.lo54.lo54ecole.service.CourseService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.lo54.lo54ecole.entity.Client;
import com.lo54.lo54ecole.repository.ClientDAO;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )throws InterruptedException
    {
        //test add Location **************************
        /*
        LocationDAO locationDAO = new LocationDAO(sessionFactory);
        Location location = new Location("Belfort");
        locationDAO.Save(location);
        */

        //test add Course ***************************
        /*
        CourseDAO courseDAO = new CourseDAO(sessionFactory);
        Course course = new Course("Informatique");
        courseDAO.Save(course);
        */

        //test add CourseSession ***********************
        /*
        LocationDAO locationDAO = new LocationDAO();
        Location loc = locationDAO.GetByCity("Belfort");

        CourseDAO courseDAO = new CourseDAO();
        Course course = courseDAO.GetByTitle("informatique et business");

        CourseSessionDAO courseSessionsDAO = new CourseSessionDAO();
        Date start=null, end=null;
        try {
            start = new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-01");
            end = new SimpleDateFormat("yyyy-MM-dd").parse("2021-06-30");
        }catch(Exception e){}
        CourseSession courseSession = new CourseSession(
                start, end,100, course, loc);
        courseSessionsDAO.Save(courseSession);
         */

        //test add Client *****************************
        /*
        ClientDAO clientDAO = new ClientDAO(sessionFactory);
        CourseSessionDAO courseSessionsDAO = new CourseSessionDAO(sessionFactory);
        CourseSession cs = courseSessionsDAO.GetById(1);

        Client client = new Client("Limacher","kevin","1 rue chantereine",
                                "0612345671", "ouiouioui@gmail.com", cs);
        clientDAO.Save(client);
        */

        //Test get Cient ***********
        /*
        ClientDAO clientDAO = new ClientDAO(sessionFactory);
        System.out.println(clientDAO.GetById(1).toString());
         */
        System.out.println( "Hello World!" );
    }
}
