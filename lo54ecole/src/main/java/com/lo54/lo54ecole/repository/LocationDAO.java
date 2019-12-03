package com.lo54.lo54ecole.repository;

import com.lo54.lo54ecole.entity.Location;
import com.lo54.lo54ecole.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class LocationDAO {
    public LocationDAO() { }

    public void save(Location l){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
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
    }

    public List<Location> getAll(){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            Query query= sess.
                    createQuery("from Location");
            List<Location> loc = (List<Location>) query.list();
            return loc;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
    }

    public Location getByCity(String city){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
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
    }
}