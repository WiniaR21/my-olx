package com.myolx.accounts.service;

import com.myolx.accounts.controller.request.CreateAccountRequest;
import com.myolx.accounts.controller.response.AccountDetails;


public interface IAccountsService {
    /**
     * Based on request creates new account.
     * @param request - CreateAccountRequest object.
     */
    void createAccount(CreateAccountRequest request);

    /**
     * Based on request update existing account.
     * @param request - CreateAccountRequest object.
     */
    void updateAccout(CreateAccountRequest request);
    /**
     *
     * @param phoneNumber - Account's phone number.
     * @return AccountDetails of account founded by phone number.
     */
    AccountDetails fetchAccountByPhoneNumber(String phoneNumber);

    /**
     *
     * @param email - Account's email.
     * @return AccountDetails of account founded by email.
     */
    AccountDetails fetchAccountByEmail(String email);
}
