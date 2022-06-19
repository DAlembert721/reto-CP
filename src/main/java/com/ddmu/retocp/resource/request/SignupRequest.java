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
    @NotBlank(message = "The email field is required")
    @Email(message = "The email field must be a email format")
    @Size(max = 50, message = "The email field must be a max size of 50")
    private String email;
    @NotBlank(message = "The email field is required")
    @Size(max = 120, message = "The email field must be a max size of 120")
    private String password;
    @NotBlank(message = "The dni field is required")
    @Size(max = 10, message = "The max size size of the dni must be 10")
    private String dni;
    @NotBlank(message = "The firstname field is required")
    @Size(max = 50, message = "The max size of the firstname must be 50")
    private String firstname;
    @NotBlank(message = "The lastname field is required")
    @Size(max = 50, message = "The max size of the lastname must be 50")
    private String lastname;
    @NotNull
    @NotBlank(message = "The address field is required")
    @Size(max = 120, message = "The max size of the address must be 50")
    private String address;


}
