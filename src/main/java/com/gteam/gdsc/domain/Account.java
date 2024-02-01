package com.gteam.gdsc.domain;

import com.gteam.gdsc.dto.AccountInfo;
import com.gteam.gdsc.dto.TransactionInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    
    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "BANK_NAME", nullable = false)
    private String bankName; // 은행명
    
    @Column(name = "ACCOUNT_NAME", nullable = false)
    private String accountName; // 계좌명
    
    @Column(name = "BALANCE", nullable = false)
    private Long balance; // 잔고

    @OneToMany(mappedBy = "account")
    @Column(name = "ACCOUNT_TRANSACTIONS")
    private List<Transaction> transactions = new ArrayList<>();

    public AccountInfo toAccountInfo() {
        List<TransactionInfo> transactionInfos = transactions.stream().map(Transaction::toAccountInfo).toList();
        return AccountInfo.builder()
                .id(this.id)
                .bankName(this.bankName)
                .accountName(this.accountName)
                .balance(this.balance)
                .transactions(transactionInfos)
                .build();
    }

    public void update(Account account) {
        this.id = account.id;
        this.bankName = account.bankName;
        this.accountName = account.accountName;
        this.balance = account.balance;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public String getName() {
        return this.accountName;
    }
}
