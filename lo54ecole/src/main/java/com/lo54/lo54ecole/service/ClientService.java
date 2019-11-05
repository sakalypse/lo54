package com.lo54.lo54ecole.service;

import com.lo54.lo54ecole.entity.Client;
import com.lo54.lo54ecole.repository.ClientDAO;

public class ClientService {

    private Client getClientById(int id){
        ClientDAO clientDAO = new ClientDAO();
        return clientDAO.GetById(id);
    }

    private void saveClient(Client c){
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.Save(c);
    }
}
