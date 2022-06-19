package com.ddmu.retocp.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;
    @NotBlank
    @Size(max = 10)
    private String dni;
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
