package com.gteam.gdsc.service;

import com.gteam.gdsc.domain.Account;
import com.gteam.gdsc.domain.Transaction;
import com.gteam.gdsc.domain.User;
import com.gteam.gdsc.dto.TransactionInfo;
import com.gteam.gdsc.dto.UserInfo;
import com.gteam.gdsc.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final AccountService accountService;

    // 거래 생성
    @Transactional
    public String createUserTransaction(TransactionInfo transactionInfo) {
        if (transactionInfo.getUserName() == null) {
            Transaction userTransaction = createTransactionWithoutUser(transactionInfo);
            transactionRepository.save(userTransaction);
            return "유저 거래 저장 성공";
        }
        Transaction userTransaction = createTransactionWithUser(transactionInfo);
        transactionRepository.save(userTransaction);
        return "유저 거래 저장 성공";
    }

    @Transactional
    public String createAccountTransaction(TransactionInfo transactionInfo) {
        if (transactionInfo.getUserName() == null) {
            Transaction accountTransaction = createTransactionWithoutAccount(transactionInfo);
            transactionRepository.save(accountTransaction);
            return "계좌 거래 저장 성공";
        }
        Transaction accountTransaction = createTransactionWithAccount(transactionInfo);
        transactionRepository.save(accountTransaction);
        return "계좌 거래 저장 성공";
    }

    private Transaction createTransactionWithoutUser(TransactionInfo transactionInfo) {
        return Transaction.builder()
                .transactionName(transactionInfo.getTransactionName())
                .useDateTime(transactionInfo.getUseDateTime())
                .useType(transactionInfo.getUseType())
                .depositDestination(transactionInfo.getDepositDestination())
                .incomeCategory(transactionInfo.getIncomeCategory())
                .incomeAmount(transactionInfo.getIncomeAmount())
                .monthlyIncome(transactionInfo.getMonthlyIncome())
                .withdrawalDestination(transactionInfo.getWithdrawalDestination())
                .expenditureCategory(transactionInfo.getExpenditureCategory())
                .expenditureAmount(transactionInfo.getExpenditureAmount())
                .monthlyExpenditure(transactionInfo.getMonthlyExpenditure())
                .build();
    }

    private Transaction createTransactionWithoutAccount(TransactionInfo transactionInfo) {
        return Transaction.builder()
                .transactionName(transactionInfo.getTransactionName())
                .useDateTime(transactionInfo.getUseDateTime())
                .useType(transactionInfo.getUseType())
                .depositDestination(transactionInfo.getDepositDestination())
                .incomeCategory(transactionInfo.getIncomeCategory())
                .incomeAmount(transactionInfo.getIncomeAmount())
                .monthlyIncome(transactionInfo.getMonthlyIncome())
                .withdrawalDestination(transactionInfo.getWithdrawalDestination())
                .expenditureCategory(transactionInfo.getExpenditureCategory())
                .expenditureAmount(transactionInfo.getExpenditureAmount())
                .monthlyExpenditure(transactionInfo.getMonthlyExpenditure())
                .build();
    }

    private Transaction createTransactionWithUser(TransactionInfo transactionInfo) {
        User user = findUserByName(transactionInfo.getUserName());
        return Transaction.builder()
                .transactionName(transactionInfo.getTransactionName())
                .useDateTime(transactionInfo.getUseDateTime())
                .useType(transactionInfo.getUseType())
                .depositDestination(transactionInfo.getDepositDestination())
                .incomeCategory(transactionInfo.getIncomeCategory())
                .incomeAmount(transactionInfo.getIncomeAmount())
                .monthlyIncome(transactionInfo.getMonthlyIncome())
                .withdrawalDestination(transactionInfo.getWithdrawalDestination())
                .expenditureCategory(transactionInfo.getExpenditureCategory())
                .expenditureAmount(transactionInfo.getExpenditureAmount())
                .monthlyExpenditure(transactionInfo.getMonthlyExpenditure())
                .user(user)
                .build();
    }

    private Transaction createTransactionWithAccount(TransactionInfo transactionInfo) {
        Account account = findAccountByName(transactionInfo.getAccountName());
        return Transaction.builder()
                .transactionName(transactionInfo.getTransactionName())
                .useDateTime(transactionInfo.getUseDateTime())
                .useType(transactionInfo.getUseType())
                .depositDestination(transactionInfo.getDepositDestination())
                .incomeCategory(transactionInfo.getIncomeCategory())
                .incomeAmount(transactionInfo.getIncomeAmount())
                .monthlyIncome(transactionInfo.getMonthlyIncome())
                .withdrawalDestination(transactionInfo.getWithdrawalDestination())
                .expenditureCategory(transactionInfo.getExpenditureCategory())
                .expenditureAmount(transactionInfo.getExpenditureAmount())
                .monthlyExpenditure(transactionInfo.getMonthlyExpenditure())
                .account(account)
                .build();
    }

    // 거래 불러오기
    public TransactionInfo findTransactionByNameAsUserInfo(String transactionName) {
        return findTransactionByName(transactionName).toUserInfo();
    }

    public TransactionInfo findTransactionByNameAsAccountInfo(String transactionName) {
        return findTransactionByName(transactionName).toAccountInfo();
    }

    // 거래 수정
    @Transactional
    public String updateUserTransaction(TransactionInfo transactionInfo) {
        Transaction userTransaction = findTransactionByName(transactionInfo.getTransactionName());
        if (transactionInfo.getUserName() != null) {
            updateTransactionWithUser(transactionInfo, userTransaction);
            transactionRepository.save(userTransaction);
            return "유저 거래 수정 성공";
        }
        updateTransactionWithoutUser(transactionInfo, userTransaction);
        transactionRepository.save(userTransaction);
        return "유저 거래 수정 성공";
    }

    @Transactional
    public String updateAccountTransaction(TransactionInfo transactionInfo) {
        Transaction accountTransaction = findTransactionByName(transactionInfo.getTransactionName());
        if (transactionInfo.getUserName() != null) {
            updateTransactionWithAccount(transactionInfo, accountTransaction);
            transactionRepository.save(accountTransaction);
            return "계좌 거래 수정 성공";
        }
        updateTransactionWithoutAccount(transactionInfo, accountTransaction);
        transactionRepository.save(accountTransaction);
        return "계좌 거래 수정 성공";
    }

    private void updateTransactionWithUser(TransactionInfo transactionInfo, Transaction transaction) {
        User user = userService.findUserByName(transactionInfo.getUserName());
        transaction.userUpdate(Transaction.builder()
                .transactionName(transactionInfo.getTransactionName())
                .useDateTime(transactionInfo.getUseDateTime())
                .useType(transactionInfo.getUseType())
                .depositDestination(transactionInfo.getDepositDestination())
                .incomeCategory(transactionInfo.getIncomeCategory())
                .incomeAmount(transactionInfo.getIncomeAmount())
                .monthlyIncome(transactionInfo.getMonthlyIncome())
                .withdrawalDestination(transactionInfo.getWithdrawalDestination())
                .expenditureCategory(transactionInfo.getExpenditureCategory())
                .expenditureAmount(transactionInfo.getExpenditureAmount())
                .monthlyExpenditure(transactionInfo.getMonthlyExpenditure())
                .user(user)
                .build());
    }

    private void updateTransactionWithAccount(TransactionInfo transactionInfo, Transaction transaction) {
        Account account = accountService.findAccountByName(transactionInfo.getAccountName());
        transaction.userUpdate(Transaction.builder()
                .transactionName(transactionInfo.getTransactionName())
                .useDateTime(transactionInfo.getUseDateTime())
                .useType(transactionInfo.getUseType())
                .depositDestination(transactionInfo.getDepositDestination())
                .incomeCategory(transactionInfo.getIncomeCategory())
                .incomeAmount(transactionInfo.getIncomeAmount())
                .monthlyIncome(transactionInfo.getMonthlyIncome())
                .withdrawalDestination(transactionInfo.getWithdrawalDestination())
                .expenditureCategory(transactionInfo.getExpenditureCategory())
                .expenditureAmount(transactionInfo.getExpenditureAmount())
                .monthlyExpenditure(transactionInfo.getMonthlyExpenditure())
                .account(account)
                .build());
    }

    private void updateTransactionWithoutUser(TransactionInfo transactionInfo, Transaction transaction) {
        transaction.userUpdate(Transaction.builder()
                .transactionName(transactionInfo.getTransactionName())
                .useDateTime(transactionInfo.getUseDateTime())
                .useType(transactionInfo.getUseType())
                .depositDestination(transactionInfo.getDepositDestination())
                .incomeCategory(transactionInfo.getIncomeCategory())
                .incomeAmount(transactionInfo.getIncomeAmount())
                .monthlyIncome(transactionInfo.getMonthlyIncome())
                .withdrawalDestination(transactionInfo.getWithdrawalDestination())
                .expenditureCategory(transactionInfo.getExpenditureCategory())
                .expenditureAmount(transactionInfo.getExpenditureAmount())
                .monthlyExpenditure(transactionInfo.getMonthlyExpenditure())
                .build());
    }

    private void updateTransactionWithoutAccount(TransactionInfo transactionInfo, Transaction transaction) {
        transaction.userUpdate(Transaction.builder()
                .transactionName(transactionInfo.getTransactionName())
                .useDateTime(transactionInfo.getUseDateTime())
                .useType(transactionInfo.getUseType())
                .depositDestination(transactionInfo.getDepositDestination())
                .incomeCategory(transactionInfo.getIncomeCategory())
                .incomeAmount(transactionInfo.getIncomeAmount())
                .monthlyIncome(transactionInfo.getMonthlyIncome())
                .withdrawalDestination(transactionInfo.getWithdrawalDestination())
                .expenditureCategory(transactionInfo.getExpenditureCategory())
                .expenditureAmount(transactionInfo.getExpenditureAmount())
                .monthlyExpenditure(transactionInfo.getMonthlyExpenditure())
                .build());
    }

    // 거래 삭제
    @Transactional
    public String deleteTransaction(String transactionName) {
        Transaction transaction = findTransactionByName(transactionName);
        transactionRepository.delete(transaction);
        return "거래 삭제 성공";
    }

    private Transaction findTransactionByName(String transactionName) {
        return transactionRepository.findTransactionByTransactionName(transactionName)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 거래명 입니다."));
    }

    private User findUserByName(String userName) {
        return userService.findUserByName(userName);
    }

    private Account findAccountByName(String accountName) {
        return accountService.findAccountByName(accountName);
    }

    private User findUserById(Long userId) {
        return userService.findUserById(userId);
    }

    private Account findAccountById(Long accountId) {
        return accountService.findAccountById(accountId);
    }
}
