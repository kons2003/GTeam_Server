package com.gteam.gdsc.controller;

import com.gteam.gdsc.dto.AccountInfo;
import com.gteam.gdsc.dto.UserInfo;
import com.gteam.gdsc.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/new")
    @Operation(description = "신규 계좌 정보 추가")
    public ResponseEntity<String> createAccount(@RequestBody AccountInfo accountInfo) {
        return ResponseEntity.ok(accountService.createAccount(accountInfo));
    }

    @GetMapping("/{name}")
    @Operation(description = "계좌 조회")
    public ResponseEntity<AccountInfo> findAccountByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(accountService.findAccountByName(name).toAccountInfo());
    }

    @PutMapping
    @Operation(description = "계좌 정보 수정")
    public ResponseEntity<String> updateAccount(@RequestBody AccountInfo accountInfo) {
        return ResponseEntity.ok(accountService.updateAccount(accountInfo));
    }

    @DeleteMapping
    @Operation(description = "계좌 정보 삭제")
    public ResponseEntity<String> deleteAccount(@RequestBody AccountInfo accountNameInfo) {
        return ResponseEntity.ok(accountService.deleteAccount(accountNameInfo));
    }
}
