package com.lo54.lo54ecole.repository;

import com.lo54.lo54ecole.entity.Course;
import com.lo54.lo54ecole.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CourseDAO {
    public CourseDAO() { }

    public void save(Course c){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
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
    }

    public Course getByTitle(String title) {
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
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
        }
    }
}