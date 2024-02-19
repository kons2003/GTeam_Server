package com.gteam.gdsc.controller;

import com.gteam.gdsc.dto.TransactionInfo;
import com.gteam.gdsc.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    // User Transaction
    @PostMapping("/user/new")
    @Operation(description = "신규 유저 거래 추가")
    public ResponseEntity<String> createUserTransaction(@RequestBody TransactionInfo transactionInfo) {
        return ResponseEntity.ok(transactionService.createUserTransaction(transactionInfo));
    }

    @GetMapping("/user/{name}")
    @Operation(description = "유저 거래 조회")
    public ResponseEntity<TransactionInfo> findUserTransactionByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(transactionService.findTransactionByNameAsUserInfo(name));
    }

    @PutMapping("/user")
    @Operation(description = "유저 정보 수정")
    public ResponseEntity<String> updateUserTransaction(@RequestBody TransactionInfo transactionInfo) {
        return ResponseEntity.ok(transactionService.updateUserTransaction(transactionInfo));
    }

    // Account Transaction
    @PostMapping("/account/new")
    @Operation(description = "신규 계좌 거래 추가")
    public ResponseEntity<String> createAccountTransaction(@RequestBody TransactionInfo transactionInfo) {
        return ResponseEntity.ok(transactionService.createAccountTransaction(transactionInfo));
    }

    @GetMapping("/account/{name}")
    @Operation(description = "계좌 거래 조회")
    public ResponseEntity<TransactionInfo> findAccountTransactionByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(transactionService.findTransactionByNameAsAccountInfo(name));
    }

    @PutMapping("/account")
    @Operation(description = "계좌 정보 수정")
    public ResponseEntity<String> updateAccountTransaction(@RequestBody TransactionInfo transactionInfo) {
        return ResponseEntity.ok(transactionService.updateAccountTransaction(transactionInfo));
    }

    @DeleteMapping
    @Operation(description = "거래 정보 삭제")
    public ResponseEntity<String> deleteTransaction(@RequestBody TransactionInfo transactionInfo) {
        return ResponseEntity.ok(transactionService.deleteTransaction(transactionInfo.getTransactionName()));
    }
}
