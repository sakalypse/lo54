package com.lo54.lo54ecole.repository;

import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.ObjectType;
import org.hibernate.type.StandardBasicTypes;

import java.util.Date;
import java.util.List;

public class CourseSessionDAO {
    public CourseSessionDAO() { }

    public void save(CourseSession cs){
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
    }

    public List<CourseSession> getByTitle(String title){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();

            Query query= sess.
                    createQuery("select cs from CourseSession cs " +
                            "INNER JOIN cs.course_code c " +
                            "where c.title like :title")
                    .setString("title", "%"+ title +"%") ;

            List<CourseSession> cs = (List<CourseSession>) query.list();
            return cs;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
    }

    public List<CourseSession> getByDate(Date date){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();

            Query query= sess.
                    createQuery("select cs from CourseSession cs " +
                            "where :date between cs.start_date and cs.end_date")
                    .setParameter("date", date) ;

            List<CourseSession> cs = (List<CourseSession>) query.list();
            return cs;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
    }

    public List<CourseSession> getByLocation(String city){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();

            Query query= sess.
                    createQuery("select cs from CourseSession cs " +
                            "INNER JOIN cs.location_id loc " +
                            "where loc.city = :city")
                    .setString("city", city) ;

            List<CourseSession> cs = (List<CourseSession>) query.list();
            return cs;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
    }

    public List<CourseSession> getAll(){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            //save courseSession cs
            return sess.createCriteria(CourseSession.class).list();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
    }

    public CourseSession getById(long id){
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
    }
}