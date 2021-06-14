package org.example.repository.impl;

import org.example.entity.Client;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ClientRepoImpl implements Repo<Client,Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Client client) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Client> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Client> clients = session.createQuery("FROM Client ").list();
        transaction.commit();
        session.close();
        return clients;
    }

    @Override
    public Client getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Client client = session.get(Client.class,id);
        transaction.commit();
        session.close();
        return client;
    }

    @Override
    public Client update(Client client) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(client);
        transaction.commit();
        session.close();
        return client;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Client client = session.get(Client.class,id);
        session.remove(client);
        transaction.commit();
        session.close();
    }
}
