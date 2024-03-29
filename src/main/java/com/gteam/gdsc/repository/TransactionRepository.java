package com.gteam.gdsc.repository;

import com.gteam.gdsc.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findTransactionByTransactionName(String transactionName);
}
