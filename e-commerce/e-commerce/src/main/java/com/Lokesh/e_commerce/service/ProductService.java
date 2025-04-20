package com.Lokesh.e_commerce.service;


import com.Lokesh.e_commerce.model.Product;
import com.Lokesh.e_commerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {


    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    public void addProduct(List<Product> product) {
        productRepo.saveAll(product);
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public Product updateProductById(int id, Product updatedProduct) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        // Set other fields as needed

        return productRepo.save(existingProduct);
    }

    public void deleteProduct(int id) {
        if (!productRepo.existsById(id)) {
            throw new RuntimeException("Product not found with ID: " + id);
        }
        productRepo.deleteById(id);
    }

}
