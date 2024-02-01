package com.gteam.gdsc.repository;

import com.gteam.gdsc.domain.Account;
import com.gteam.gdsc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountById(Long accountId);
    Optional<Account> findAccountByAccountName(String accountName);
}
