package com.ddmu.retocp.service;

import com.ddmu.retocp.domain.model.Order;
import com.ddmu.retocp.domain.model.Product;
import com.ddmu.retocp.domain.repository.OrderRepository;
import com.ddmu.retocp.domain.repository.ProductRepository;
import com.ddmu.retocp.domain.service.OrderService;
import com.ddmu.retocp.exception.ModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable)
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Order createOrder(Long productCode, Order order) {
        Product product = productRepository.findByCode(productCode)
                .orElseThrow(() ->
                        new ModelNotFoundException("Product", "Code", productCode));
        order.setProduct(product);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderByNumber(Long orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() ->
                        new ModelNotFoundException("Order", "OrderNumber", orderNumber));
    }

    @Override
    public Order editOrderByOrderNumber(Long orderNumber, Order resource) {
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() ->
                        new ModelNotFoundException("Order", "OrderNumber", orderNumber));
        order.setQuantity(resource.getQuantity());
        order.setOrderNumber(resource.getOrderNumber());
        return orderRepository.save(order);
    }

    @Override
    public ResponseEntity<?> deleteOrderByOrderNumber(Long orderNumber) {
        orderRepository.deleteOrderByOrderNumber(orderNumber);
        return ResponseEntity.ok().build();
    }
}
