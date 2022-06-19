package com.ddmu.retocp.domain.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Client {
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String firstname;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String lastname;

    @NotNull
    @NotBlank
    @Size(max = 120)
    private String address;
}
