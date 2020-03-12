package com.busyqa.products.service;

import com.busyqa.products.domain.Product;
import com.busyqa.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProduct(long id) {
        return repository.findById(id);
    }

    public void save(Product p) {
        repository.save(p);
    }
}
