package org.example.repository.impl;

import org.example.entity.Product;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ProductRepoImpl implements Repo<Product,Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Product product) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Product> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Product> products = session.createQuery("FROM Product").list();
        transaction.commit();
        session.close();
        return products;
    }

    @Override
    public Product getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Product product = session.get(Product.class,id);
        transaction.commit();
        session.close();
        return product;
    }

    @Override
    public Product update(Product product) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(product);
        transaction.commit();
        session.close();
        return product;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Product product = session.get(Product.class,id);
        session.remove(product);
        transaction.commit();
        session.close();
    }
}
