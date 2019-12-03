package com.lo54.lo54ecole.service;

import com.lo54.lo54ecole.entity.Client;
import com.lo54.lo54ecole.entity.CourseSession;
import com.lo54.lo54ecole.repository.ClientDAO;

public class ClientService {

    public Client getClientById(int id){
        ClientDAO clientDAO = new ClientDAO();
        return clientDAO.getById(id);
    }

    public void saveClient(Client c){
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.save(c);
    }

    public int getCountClientByCourseSession(CourseSession courseSession){
        ClientDAO clientDAO = new ClientDAO();
        return clientDAO.getCountClientByCourseSession(courseSession);
    }
}
