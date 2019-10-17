package com.lo54.lo54ecole;

import com.lo54.lo54ecole.entity.Location;
import com.lo54.lo54ecole.repository.LocationDAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.lo54.lo54ecole.entity.Client;
import com.lo54.lo54ecole.repository.ClientDAO;

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

        //test add one location
        LocationDAO locationDAO = new LocationDAO(sessionFactory);
        Location location = new Location(2, "Belfort");
        locationDAO.Save(location);

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
