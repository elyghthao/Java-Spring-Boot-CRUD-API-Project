package com.elygh.projectTest.service;

import com.elygh.projectTest.model.Product;
import com.elygh.projectTest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProduct(long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(long productId, Product product) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("not found"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setColor(product.getColor());
        existingProduct.setProductName((product.getProductName()));
        productRepository.save(existingProduct);
        return existingProduct;

    }

    public Product deleteproduct(long productId) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("404 not found"));
        productRepository.deleteById(productId);
        return existingProduct;
    }

    public List<Product> getProductsByName(String productName) {
        return productRepository.getProductsByName(productName);
    }
}
