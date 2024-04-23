package com.myolx.accounts.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AccountDetails {
    private String phoneNumber;
    private String email;
    private String firstName;
    private String lastName;
}
