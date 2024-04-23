package com.myolx.accounts.repository;

import com.myolx.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByPhoneNumber(String phoneNumber);
}
