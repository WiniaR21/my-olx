package com.myolx.accounts.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class CreateAccountRequest {
    private String phoneNumber;
    private String email;
    private String firstName;
    private String lastName;
}
