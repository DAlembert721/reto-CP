package com.ddmu.retocp.resource.response;

import lombok.Data;

@Data
public class OrderResponse {
    private Long orderNumber;
    private Long productCode;
    private Integer quantity;
    private ClientResponse client;
}
