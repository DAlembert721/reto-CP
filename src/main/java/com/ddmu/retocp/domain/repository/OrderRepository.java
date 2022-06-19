package com.ddmu.retocp.domain.repository;

import com.ddmu.retocp.domain.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends BaseRepository<Order, String>{
    Optional<Order> findByOrderNumber(Long orderNumber);
    void deleteOrderByOrderNumber(Long orderNumber);
}
