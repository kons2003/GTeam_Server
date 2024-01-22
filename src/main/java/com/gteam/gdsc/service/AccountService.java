package com.gteam.gdsc.service;

import com.gteam.gdsc.domain.Account;
import com.gteam.gdsc.dto.AccountInfo;
import com.gteam.gdsc.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    // 계좌 추가
    @Transactional
    public String createAccount(AccountInfo accountInfo) {
        Account account = Account.builder()
                .bankName(accountInfo.getBankName())
                .accountName(accountInfo.getAccountName())
                .balance(accountInfo.getBalance())
                .build();
        accountRepository.save(account);
        return "account 추가 성공";
    }




}
