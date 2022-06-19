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
    @NotNull
    private Long code;
    @NotBlank
    @Size(max = 200)
    private String name;
    @NotNull
    private Long price;
}
