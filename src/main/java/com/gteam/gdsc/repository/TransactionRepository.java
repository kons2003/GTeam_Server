package com.gteam.gdsc.repository;

import com.gteam.gdsc.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
