package com.myolx.accounts.exception;

public class AccountAlreadyExistException extends RuntimeException{

    public AccountAlreadyExistException(String phoneNumber) {
        super("Account with phoneNumber: " + phoneNumber + " already exist.");
    }
}
