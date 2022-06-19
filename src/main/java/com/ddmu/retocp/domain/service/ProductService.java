package com.ddmu.retocp.domain.service;

import com.ddmu.retocp.domain.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts(Pageable pageable);
    Product getProductByCode(Long code);
    Product createProduct(Product product);
    Product editProductByCode(Long code, Product product);
    ResponseEntity<?> deleteProduct(Long code);
}
