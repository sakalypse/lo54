package com.lo54.lo54ecole.repository;

import com.lo54.lo54ecole.entity.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LocationDAO {

    private SessionFactory sessionFactory;

    public LocationDAO(SessionFactory sf) {
        sessionFactory = sf;
    }

    public void Save(Location l){
        Session sess = sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            //save localisation l
            sess.save(l);
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

    public Location GetByCity(String city){
        Session sess = sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            //save localisation l
            Query query= sess.
                    createQuery("from Location where city=:city");
            query.setParameter("city", city);
            Location loc = (Location) query.uniqueResult();
            return loc;
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