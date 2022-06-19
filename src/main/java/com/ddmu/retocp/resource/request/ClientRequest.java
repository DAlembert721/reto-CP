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
public class ClientRequest {
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
