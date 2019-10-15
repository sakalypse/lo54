package com.lo54.lo54ecole.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.lo54.lo54ecole.entity.Client;

public class ClientDAO {

    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public ClientDAO() {
    }
}