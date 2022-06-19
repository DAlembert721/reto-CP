package com.ddmu.retocp.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    @NotNull(message = "The orderNumber field is required")
    private Long orderNumber;
    @NotNull(message = "The productCode field is required")
    private Long productCode;
    @NotNull(message = "The quantity field is required")
    private Integer quantity;

    @NotNull(message = "The client field is required")
    @Valid
    private ClientRequest client;
}
