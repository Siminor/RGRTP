package org.example.repository.impl;
import org.example.entity.Seller;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class SellerRepoImpl implements Repo<Seller,Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Seller seller) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(seller);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Seller> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Seller> sellers = session.createQuery("FROM Seller").list();
        transaction.commit();
        session.close();
        return sellers;
    }

    @Override
    public Seller getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Seller seller = session.get(Seller.class,id);
        transaction.commit();
        session.close();
        return seller;
    }

    @Override
    public Seller update(Seller seller) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(seller);
        transaction.commit();
        session.close();
        return seller;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Seller seller = session.get(Seller.class,id);
        session.remove(seller);
        transaction.commit();
        session.close();
    }
}
