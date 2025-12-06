package com.example.simpleecommerceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleecommerceapp.entity.Product;
import com.example.simpleecommerceapp.repo.ProductRepo;



@Service
public class ProductService {
    
    @Autowired
     private ProductRepo productRepo;
     public List<Product> getAllpProducts() {
        return productRepo.findAll();
    }

    public Product getUserById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    public void createProduct(Product Product) {
        productRepo.save(Product);
    }

    public void UpdateProduct(Product Product , Long id) {
        productRepo.findById(Product.getId()).orElseThrow(() -> new RuntimeException("Admin not found with id: " + Product.getId()));
        productRepo.save(Product);
    }

    public void deleteProduct( Long id) {
        productRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        productRepo.deleteById(id);
    }

    

}
