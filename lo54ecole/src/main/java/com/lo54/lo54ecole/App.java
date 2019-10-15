package com.lo54.lo54ecole;

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

        //test ajout d'un client
        ClientDAO clientDAO = new ClientDAO(sessionFactory);
        Client client = new Client("1",
        "limacher", "kevin", 
        "belfort", "069887760", "kevin@gmail.com",
        "10");
        clientDAO.Save(client);

        System.out.println( "Hello World!" );
    }

    private static void SetupSessionFactoryDatabase(){
        Configuration config = new Configuration();
        sessionFactory = config.buildSessionFactory();
    }
}
