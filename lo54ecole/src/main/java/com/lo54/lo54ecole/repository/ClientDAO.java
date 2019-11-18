package com.lo54.lo54ecole.repository;

import java.util.List;

import com.lo54.lo54ecole.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.lo54.lo54ecole.entity.Client;

public class ClientDAO {
    public ClientDAO() { }

    public void Save(Client c){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
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
    }

    public Client GetById(long id){
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            //save client c
            Client c = (Client) sess.get(Client.class, id);
            return c;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
    }
}