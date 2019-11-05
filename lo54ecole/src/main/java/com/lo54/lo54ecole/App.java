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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    private static SessionFactory sessionFactory;
    public static void main( String[] args )
    {
        //setup session database
        SetupSessionFactoryDatabase();

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
        LocationDAO locationDAO = new LocationDAO(sessionFactory);
        Location loc = locationDAO.GetByCity("Masevaux");

        CourseDAO courseDAO = new CourseDAO(sessionFactory);
        Course course = courseDAO.GetByTitle("Informatique");

        CourseSessionDAO courseSessionsDAO = new CourseSessionDAO(sessionFactory);
        Date start=null, end=null;
        try {
            start = new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-01");
            end = new SimpleDateFormat("yyyy-MM-dd").parse("2021-06-30");
        }catch(Exception e){}
        CourseSession courseSession = new CourseSession(
                start, end,130, course, loc);
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

    private static void SetupSessionFactoryDatabase(){
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration()
                        .configure()
                        .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }
}
