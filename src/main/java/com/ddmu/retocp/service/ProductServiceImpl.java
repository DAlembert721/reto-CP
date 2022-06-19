package com.ddmu.retocp.service;

import com.ddmu.retocp.domain.model.Product;
import com.ddmu.retocp.domain.repository.ProductRepository;
import com.ddmu.retocp.domain.service.ProductService;
import com.ddmu.retocp.exception.ModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductByCode(Long code) {
        return productRepository.findByCode(code)
                .orElseThrow(() ->
                        new ModelNotFoundException("Product", "Code", code));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product editProductByCode(Long code, Product resource) {
        Product product = productRepository.findByCode(code)
                .orElseThrow(() ->
                        new ModelNotFoundException("Product", "Code", code));
        product.setCode(resource.getCode());
        product.setName(resource.getName());
        product.setPrice(resource.getPrice());
        return productRepository.save(product);
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long code) {
        productRepository.deleteByCode(code);
        return ResponseEntity.ok().build();
    }
}
