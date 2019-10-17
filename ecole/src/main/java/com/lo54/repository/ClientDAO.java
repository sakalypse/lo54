package com.lo54.lo54ecole.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.lo54.lo54ecole.entity.Client;

public class ClientDAO {

    private SessionFactory sessionFactory;
 
    public ClientDAO(SessionFactory sf) {
        sessionFactory = sf;
    }

    public void Save(Client c){
        Session sess = sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            //save client c
            sess.save(c);
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            sess.close();
        }
    }
}