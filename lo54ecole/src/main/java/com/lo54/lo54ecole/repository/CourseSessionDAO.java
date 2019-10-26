package com.lo54.lo54ecole.repository;

import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CourseSessionDAO {
    public CourseSessionDAO() { }

    public void Save(CourseSession cs){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
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

    public CourseSession GetById(long id){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            //save courseSession cs
            CourseSession cs = (CourseSession) sess.get(CourseSession.class, id);
            return cs;
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