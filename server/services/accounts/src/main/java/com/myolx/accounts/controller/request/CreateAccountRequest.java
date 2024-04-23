package com.myolx.accounts.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class CreateAccountRequest {

    @Pattern(regexp="(^$|[0-9]{9})",message = "PhoneNumber must be 9 digits")
    @NotNull(message = "PhoneNumber can not be empty")
    private String phoneNumber;

    @Email
    @NotNull(message = "Email can not be empty")
    private String email;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "FirstName must contain only letters")
    @NotNull(message = "FirstName can not be empty")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "LastName must contain only letters")
    @NotNull(message = "LastName can not be empty")
    private String lastName;
}
