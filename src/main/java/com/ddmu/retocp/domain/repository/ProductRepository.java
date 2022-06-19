package com.ddmu.retocp.domain.repository;

import com.ddmu.retocp.domain.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends BaseRepository<Product, String>{
    Boolean existsProductByCode(Long code);
    Optional<Product> findByCode(Long code);
    void deleteByCode(Long code);
}
