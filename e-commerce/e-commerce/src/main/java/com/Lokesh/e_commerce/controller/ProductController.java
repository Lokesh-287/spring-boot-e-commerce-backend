package com.Lokesh.e_commerce.controller;


import com.Lokesh.e_commerce.model.Product;
import com.Lokesh.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;
    private org.springframework.web.bind.annotation.RequestBody RequestBody;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new  ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id")int id){
       Product product=productService.getProductById(id);
       return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody List<Product> product) {
        productService.addProduct(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") int id,
            @RequestBody Product updatedProduct) {
        Product product = productService.updateProductById(id, updatedProduct);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

}
