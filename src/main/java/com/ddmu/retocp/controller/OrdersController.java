package com.ddmu.retocp.controller;

import com.ddmu.retocp.domain.model.Order;
import com.ddmu.retocp.domain.service.OrderService;
import com.ddmu.retocp.resource.request.OrderRequest;
import com.ddmu.retocp.resource.response.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get all orders", description = "Get All orders")
    @GetMapping("")
    public Page<OrderResponse> getAllOrders(Pageable pageable) {
        List<OrderResponse> responses = orderService.getAllOrders(pageable)
                .stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
        return new PageImpl<>(responses, pageable, responses.size());
    }
    @Operation(summary = "Get an order", description = "Get an order by number")
    @GetMapping("/{orderNumber}")
    public OrderResponse getOrderByNumber(@PathVariable Long orderNumber) {
        return mapEntityToResponse(orderService.getOrderByNumber(orderNumber));
    }

    @Operation(summary = "Create an order", description = "Create an order")
    @PostMapping("")
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest request) {
        return mapEntityToResponse(orderService.createOrder(request.getProductCode(), mapRequestToEntity(request)));
    }

    @Operation(summary = "Update an order", description = "Update an order")
    @PutMapping("")
    public OrderResponse editProduct(@RequestBody @Valid OrderRequest request){
        Order order = mapRequestToEntity(request);
        return mapEntityToResponse(orderService.editOrderByOrderNumber(request.getOrderNumber(), order));
    }

    @Operation(summary = "Delete an order", description = "Delete an order")
    @DeleteMapping("/{orderNumber}")
    public ResponseEntity<?> deleteOrderByOrderNumber(@PathVariable Long orderNumber) {
        return orderService.deleteOrderByOrderNumber(orderNumber);
    }

    private OrderResponse mapEntityToResponse(Order order){
        return mapper.map(order, OrderResponse.class);
    }

    private Order mapRequestToEntity(OrderRequest request){
        return mapper.map(request, Order.class);
    }
}
