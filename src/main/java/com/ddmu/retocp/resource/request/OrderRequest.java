package com.ddmu.retocp.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    @NotNull
    private Long orderNumber;
    @NotNull
    private Long productCode;
    @NotNull
    private Integer quantity;
    @NotNull
    private ClientRequest client;
}
