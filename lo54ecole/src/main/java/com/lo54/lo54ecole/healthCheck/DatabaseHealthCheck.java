package com.lo54.lo54ecole.healthCheck;

import com.codahale.metrics.health.HealthCheck;
import com.lo54.lo54ecole.entity.Client;
import com.lo54.lo54ecole.entity.Location;
import com.lo54.lo54ecole.service.ClientService;
import com.lo54.lo54ecole.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DatabaseHealthCheck extends HealthCheck {
    @Override
    public HealthCheck.Result check() throws Exception {
        Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx = sess.beginTransaction();
            //TODO : on suppose qu'il y a toujours un id '1'. A changer
            sess.get(Location.class, Long.valueOf(1));
            return HealthCheck.Result.healthy();
        } catch(Exception e){
            System.out.println("ouiiiiiiiiiii"+e);
            return HealthCheck.Result.unhealthy("Cannot connect to database");
        }
    }
}