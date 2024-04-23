package com.myolx.accounts.controller;

import com.myolx.accounts.controller.request.CreateAccountRequest;
import com.myolx.accounts.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/accounts")
@RequiredArgsConstructor
public class AccountsController {
    private final IAccountsService accountsService;
    @PostMapping(path = "/create")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest request){
        accountsService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
