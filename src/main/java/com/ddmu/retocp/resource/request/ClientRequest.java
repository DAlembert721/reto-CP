package com.ddmu.retocp.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    @NotBlank
    @Size(max = 50)
    private String firstname;
    @NotBlank
    @Size(max = 50)
    private String lastname;
    @NotBlank
    @Size(max = 120)
    private String address;
}
