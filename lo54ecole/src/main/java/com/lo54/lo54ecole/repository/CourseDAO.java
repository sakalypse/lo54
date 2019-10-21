package com.lo54.lo54ecole.repository;

import com.lo54.lo54ecole.entity.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CourseDAO {

    private SessionFactory sessionFactory;

    public CourseDAO(SessionFactory sf) {
        sessionFactory = sf;
    }

    public void Save(Course c){
        Session sess = sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            //save course c
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

    public Course GetByTitle(String title) {
        Session sess = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            //save localisation l
            Query query = sess.
                    createQuery("from Course where title=:title");
            query.setParameter("title", title);
            Course course = (Course) query.uniqueResult();
            return course;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            sess.close();
        }
    }
}