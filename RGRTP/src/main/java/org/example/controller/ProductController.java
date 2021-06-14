package org.example.controller;

import org.example.entity.Client;
import org.example.entity.Product;
import org.example.repository.Repo;
import org.example.repository.impl.ProductRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductController {
    private Repo repo = new ProductRepoImpl();

    public Product editProduct(Product product) throws SQLException {
        return (Product) repo.update(product);
    }

    public List<Product> getAllProducts() throws SQLException {
        return repo.getAll();
    }

    public void saveProduct(Product product) throws SQLException {
        repo.add(product);
    }

    public void deleteProduct(Long id) throws SQLException {
        repo.remove(id);
    }
    public Product getProductById(Long id) throws SQLException {
        return (Product) repo.getById(id);
    }
}
