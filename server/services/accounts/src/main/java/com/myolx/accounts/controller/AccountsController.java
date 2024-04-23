package com.myolx.accounts.controller;

import com.myolx.accounts.controller.request.CreateAccountRequest;
import com.myolx.accounts.controller.response.AccountDetails;
import com.myolx.accounts.service.IAccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/accounts")
@RequiredArgsConstructor
@Validated
public class AccountsController {
    private final IAccountsService accountsService;
    @PostMapping(path = "/create")
    public ResponseEntity<?> createAccount(@Valid @RequestBody CreateAccountRequest request){
        accountsService.createAccount(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(null);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateAccount(@Valid @RequestBody CreateAccountRequest request){
        accountsService.updateAccout(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

    @GetMapping(path = "/fetch-by-phone")
    public ResponseEntity<AccountDetails> fetchAccountByPhoneNumber(
            @Pattern(regexp="(^$|[0-9]{9})",message = "PhoneNumber must be 9 digits")
            @NotNull(message = "PhoneNumber can not be empty")
            @Valid @RequestParam String phoneNumber){
        return ResponseEntity
                .ok()
                .body(accountsService.fetchAccountByPhoneNumber(phoneNumber));
    }

    @GetMapping(path = "/fetch-by-email")
    public ResponseEntity<AccountDetails> fetchAccountByEmail(
            @Email
            @NotNull(message = "Email can not be empty")
            @Valid @RequestParam String email){
        return ResponseEntity
                .ok()
                .body(accountsService.fetchAccountByEmail(email));
    }
}
