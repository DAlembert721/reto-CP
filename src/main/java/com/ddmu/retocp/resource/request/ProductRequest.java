package com.ddmu.retocp.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotNull(message = "The code field is required")
    private Long code;
    @NotBlank(message = "The name field is required")
    @Size(max = 200, message = "The name field must be a max size of 200")
    private String name;
    @NotNull(message = "The price field is required")
    private Long price;
}
