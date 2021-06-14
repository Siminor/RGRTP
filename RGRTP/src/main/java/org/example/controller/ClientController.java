package org.example.controller;

import org.example.entity.Client;
import org.example.repository.Repo;
import org.example.repository.impl.ClientRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ClientController {
    private Repo repo = new ClientRepoImpl();

    public Client editClient(Client client) throws SQLException {
        return (Client) repo.update(client);
    }

    public List<Client> getAllClients() throws SQLException {
        return repo.getAll();
    }

    public void saveClient(Client client) throws SQLException {
        repo.add(client);
    }

    public void deleteClient(Long id) throws SQLException {
        repo.remove(id);
    }

    public Client getClientById(Long id) throws SQLException {
        return (Client) repo.getById(id);
    }
}
