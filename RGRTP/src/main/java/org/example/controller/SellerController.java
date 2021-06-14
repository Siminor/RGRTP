package org.example.controller;

import org.example.entity.Seller;
import org.example.repository.Repo;
import org.example.repository.impl.SellerRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class SellerController {
    private Repo repo = new SellerRepoImpl();

    public Seller editSeller(Seller seller) throws SQLException {
        return (Seller) repo.update(seller);
    }

    public List<Seller> getAllSellers() throws SQLException {
        return repo.getAll();
    }

    public void saveSeller(Seller seller) throws SQLException {
        repo.add(seller);
    }

    public void deleteSeller(Long id) throws SQLException {
        repo.remove(id);
    }

    public Seller getSellerById(Long id) throws SQLException {
        return (Seller) repo.getById(id);
    }
}
