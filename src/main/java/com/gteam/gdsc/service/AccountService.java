package com.gteam.gdsc.service;

import com.gteam.gdsc.domain.Account;
import com.gteam.gdsc.dto.AccountInfo;
import com.gteam.gdsc.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    // 계좌 추가
    public String createAccount(AccountInfo accountInfo) {
        Account account = Account.builder()
                .bankName(accountInfo.getBankName())
                .accountName(accountInfo.getAccountName())
                .balance(accountInfo.getBalance())
                .build();
        accountRepository.save(account);
        return "account 추가 성공";
    }

    // 계좌 불러오기
    public Account readAccountByName(String accountName) {
        return accountRepository.findAccountByAccountName(accountName)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 계좌명 입니다."));
    }

    // 계좌 수정하기
    public String updateAccount(AccountInfo accountInfo) {
        Account account = accountRepository.findById(accountInfo.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 계좌 ID 입니다."));
        account.update(Account.builder()
                .id(accountInfo.getAccountId())
                .bankName(accountInfo.getBankName())
                .accountName(accountInfo.getAccountName())
                .balance(accountInfo.getBalance())
                .build());
        return "수정 성공";
    }

    // 계좌 삭제
    public String deleteAccount(AccountInfo accountInfo) {
        Account account = readAccountByName(accountInfo.getAccountName());
        accountRepository.delete(account);
        return "삭제 성공";
    }


}
