package com.myolx.accounts.service.impl;

import com.myolx.accounts.controller.request.CreateAccountRequest;
import com.myolx.accounts.controller.response.AccountDetails;
import com.myolx.accounts.entity.Account;
import com.myolx.accounts.repository.AccountRepository;
import com.myolx.accounts.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountsService {

    private final AccountRepository accountRepository;
    /**
     * Based on request creates new account.
     *
     * @param request - CreateAccountRequest object.
     */
    @Override
    public void createAccount(CreateAccountRequest request) {
        Optional<Account> optionalAccount = accountRepository.findByPhoneNumber(request.getPhoneNumber());
        if (optionalAccount.isPresent()){
            //TODO Custom exception
            throw new RuntimeException("Account already exist");
        }
        else {
            Account account = new Account(
                    request.getPhoneNumber(),
                    request.getEmail(),
                    request.getFirstName(),
                    request.getLastName()
            );
            accountRepository.save(account);
        }
    }

    /**
     * Based on request update existing account.
     *
     * @param request - CreateAccountRequest object.
     */
    @Override
    public void updateAccout(CreateAccountRequest request) {
        Optional<Account> optionalAccount = accountRepository.findByPhoneNumber(request.getPhoneNumber());
        if (optionalAccount.isEmpty()){
            //TODO Custom exception
            throw new RuntimeException("Account not found");
        }
        else {
            Account account = optionalAccount.get();
            account.setEmail(request.getEmail());
            account.setFirstName(request.getFirstName());
            account.setLastName(request.getLastName());
            accountRepository.save(account);
        }
    }

    /**
     * @param phoneNumber - Account's phone number.
     * @return AccountDetails of account founded by phone number.
     */
    @Override
    public AccountDetails fetchAccountByPhoneNumber(String phoneNumber) {
        Optional<Account> optionalAccount = accountRepository.findByPhoneNumber(phoneNumber);
        if(optionalAccount.isEmpty()){
            //TODO Custom exception
            throw new RuntimeException("Account not found");
        }
        else {
            Account account = optionalAccount.get();
            return new AccountDetails(
                    account.getPhoneNumber(),
                    account.getEmail(),
                    account.getFirstName(),
                    account.getLastName()
            );
        }
    }

    /**
     * @param email - Account's email.
     * @return AccountDetails of account founded by email.
     */
    @Override
    public AccountDetails fetchAccountByEmail(String email) {
        Optional<Account> optionalAccount = accountRepository.findByEmail(email);
        if (optionalAccount.isEmpty()){
            throw new RuntimeException("Account not found");
        }
        else {
            Account account = optionalAccount.get();
            return new AccountDetails(
                    account.getPhoneNumber(),
                    account.getEmail(),
                    account.getFirstName(),
                    account.getLastName()
            );
        }
    }
}
