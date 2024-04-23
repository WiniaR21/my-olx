package com.myolx.accounts.service;

import com.myolx.accounts.controller.request.CreateAccountRequest;

public interface IAccountsService {
    /**
     * Based on request creates new account.
     * @param request - CreateAccountRequest object.
     */
    void createAccount(CreateAccountRequest request);
}
