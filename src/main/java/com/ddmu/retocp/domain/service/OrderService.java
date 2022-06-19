package com.ddmu.retocp.domain.service;

import com.ddmu.retocp.domain.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders(Pageable pageable);
    Order createOrder(Long productCode, Order order);
    Order getOrderByNumber(Long orderNumber);
    Order editOrderByOrderNumber(Long orderNumber, Order order);
    ResponseEntity<?> deleteOrderByOrderNumber(Long orderNumber);

}
