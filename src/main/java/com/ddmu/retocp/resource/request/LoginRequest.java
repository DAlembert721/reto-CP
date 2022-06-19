package com.ddmu.retocp.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "The email field is required")
    @Email(message = "The email field must be a email format")
    @Size(max = 50, message = "The email field must be a max size of 50")
    private String email;

    @NotBlank(message = "The email field is required")
    @Size(max = 120, message = "The email field must be a max size of 120")
    private String password;
}
