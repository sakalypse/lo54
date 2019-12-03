package com.lo54.lo54ecole.healthCheck;

import com.codahale.metrics.health.HealthCheck;
import com.lo54.lo54ecole.utils.HibernateUtil;

public class DatabaseHealthCheck extends HealthCheck {
    @Override
    public HealthCheck.Result check() throws Exception {
        if ( HibernateUtil.getSessionFactory().getCurrentSession()!=null) {
            return HealthCheck.Result.healthy();
        } else {
            return HealthCheck.Result.unhealthy("Cannot connect to database");
        }
    }
}