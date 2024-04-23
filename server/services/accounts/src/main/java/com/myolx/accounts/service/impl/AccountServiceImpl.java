package com.myolx.accounts.service.impl;

import com.myolx.accounts.controller.request.CreateAccountRequest;
import com.myolx.accounts.controller.response.AccountDetails;
import com.myolx.accounts.service.IAccountsService;

public class AccountServiceImpl implements IAccountsService {
    /**
     * Based on request creates new account.
     *
     * @param request - CreateAccountRequest object.
     */
    @Override
    public void createAccount(CreateAccountRequest request) {

    }

    /**
     * @param phoneNumber - Account's phone number.
     * @return AccountDetails of account founded by phone number.
     */
    @Override
    public AccountDetails fetchAccountByPhoneNumber(String phoneNumber) {
        return null;
    }

    /**
     * @param email - Account's email.
     * @return AccountDetails of account founded by email.
     */
    @Override
    public AccountDetails fetchAccountByEmail(String email) {
        return null;
    }
}
