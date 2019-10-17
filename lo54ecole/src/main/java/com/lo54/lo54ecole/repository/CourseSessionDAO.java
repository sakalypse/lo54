package com.lo54.lo54ecole.repository;

import com.lo54.lo54ecole.entity.CourseSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CourseSessionDAO {

    private SessionFactory sessionFactory;

    public CourseSessionDAO(SessionFactory sf) {
        sessionFactory = sf;
    }

    public void Save(CourseSession cs){
        Session sess = sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            //save courseSession cs
            sess.save(cs);
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