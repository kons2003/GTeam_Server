package com.gteam.gdsc.domain;

import com.gteam.gdsc.dto.TransactionInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @Column(name = "TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // transaction id

    @Column(name = "TRANSACTION_NAME")
    private String transactionName; // 거래명

    @Column(name = "USE_DATETIME", nullable = false)
    private LocalDateTime useDateTime; // 사용 날짜, 시간

    @Column(name = "USE_TYPE", nullable = false)
    private String useType; // 구분(수입, 지출 등)

    @Column(name = "DEPOSIT_DESTINATION")
    private String depositDestination; // 입금처

    @Column(name = "INCOME_CATEGORY")
    private String incomeCategory; // 소득 분야

    @Column(name = "INCOME_AMOUNT")
    private Long incomeAmount; // 소득 금액

    @Column(name = "MONTHLY_INCOME")
    private Long monthlyIncome; // 한 달 소득 금액

    @Column(name = "WITHDRAWAL_DESTINATION")
    private String withdrawalDestination; // 출금처

    @Column(name = "EXPENDITURE_CATEGORY")
    private String expenditureCategory; // 지출 분야

    @Column(name = "EXPENDITURE_AMOUNT")
    private Long expenditureAmount; // 지출 금액

    @Column(name = "MONTHLY_EXPENDITURE")
    private Long monthlyExpenditure; // 한 달 지출 금액

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public TransactionInfo toUserInfo() {
        if (user != null) {
            return TransactionInfo.builder()
                    .transactionId(this.id)
                    .transactionName(this.transactionName)
                    .useDateTime(this.useDateTime)
                    .useType(this.useType)
                    .depositDestination(this.depositDestination)
                    .incomeCategory(this.incomeCategory)
                    .incomeAmount(this.incomeAmount)
                    .monthlyIncome(this.monthlyIncome)
                    .withdrawalDestination(this.withdrawalDestination)
                    .expenditureCategory(this.expenditureCategory)
                    .expenditureAmount(this.expenditureAmount)
                    .monthlyExpenditure(this.monthlyExpenditure)
                    .userName(user.getName())
                    .build();
        }
        return TransactionInfo.builder()
                .transactionId(this.id)
                .transactionName(this.transactionName)
                .useDateTime(this.useDateTime)
                .useType(this.useType)
                .depositDestination(this.depositDestination)
                .incomeCategory(this.incomeCategory)
                .incomeAmount(this.incomeAmount)
                .monthlyIncome(this.monthlyIncome)
                .withdrawalDestination(this.withdrawalDestination)
                .expenditureCategory(this.expenditureCategory)
                .expenditureAmount(this.expenditureAmount)
                .monthlyExpenditure(this.monthlyExpenditure)
                .build();
    }

    public TransactionInfo toAccountInfo() {
        if (account != null) {
            return TransactionInfo.builder()
                    .transactionId(this.id)
                    .transactionName(this.transactionName)
                    .useDateTime(this.useDateTime)
                    .useType(this.useType)
                    .depositDestination(this.depositDestination)
                    .incomeCategory(this.incomeCategory)
                    .incomeAmount(this.incomeAmount)
                    .monthlyIncome(this.monthlyIncome)
                    .withdrawalDestination(this.withdrawalDestination)
                    .expenditureCategory(this.expenditureCategory)
                    .expenditureAmount(this.expenditureAmount)
                    .monthlyExpenditure(this.monthlyExpenditure)
                    .userName(account.getAccountName())
                    .build();
        }
        return TransactionInfo.builder()
                .transactionId(this.id)
                .transactionName(this.transactionName)
                .useDateTime(this.useDateTime)
                .useType(this.useType)
                .depositDestination(this.depositDestination)
                .incomeCategory(this.incomeCategory)
                .incomeAmount(this.incomeAmount)
                .monthlyIncome(this.monthlyIncome)
                .withdrawalDestination(this.withdrawalDestination)
                .expenditureCategory(this.expenditureCategory)
                .expenditureAmount(this.expenditureAmount)
                .monthlyExpenditure(this.monthlyExpenditure)
                .build();
    }

    public void userUpdate(Transaction transaction) {
        this.id = transaction.id;
        this.transactionName = transaction.transactionName;
        this.useDateTime = transaction.useDateTime;
        this.useType = transaction.useType;
        this.depositDestination = transaction.depositDestination;
        this.incomeCategory = transaction.incomeCategory;
        this.incomeAmount = transaction.incomeAmount;
        this.monthlyIncome = transaction.monthlyIncome;
        this.withdrawalDestination = transaction.withdrawalDestination;
        this.expenditureCategory = transaction.expenditureCategory;
        this.expenditureAmount = transaction.expenditureAmount;
        this.monthlyExpenditure = transaction.monthlyExpenditure;
        if (user != null) {
            changeUser(transaction.user);
            return;
        }
        this.user = transaction.user;
    }

    public void accountUpdate(Transaction transaction) {
        this.id = transaction.id;
        this.transactionName = transaction.transactionName;
        this.useDateTime = transaction.useDateTime;
        this.useType = transaction.useType;
        this.depositDestination = transaction.depositDestination;
        this.incomeCategory = transaction.incomeCategory;
        this.incomeAmount = transaction.incomeAmount;
        this.monthlyIncome = transaction.monthlyIncome;
        this.withdrawalDestination = transaction.withdrawalDestination;
        this.expenditureCategory = transaction.expenditureCategory;
        this.expenditureAmount = transaction.expenditureAmount;
        this.monthlyExpenditure = transaction.monthlyExpenditure;
        if (account != null) {
            changeAccount(transaction.account);
            return;
        }
        this.account = transaction.account;
    }

    public void changeUser(User user) {
        this.user = user;
        user.getTransactions().add(this);
    }

    public void changeAccount(Account account) {
        this.account = account;
        account.getTransactions().add(this);
    }
}
