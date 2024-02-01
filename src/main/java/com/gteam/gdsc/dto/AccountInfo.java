package com.gteam.gdsc.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class AccountInfo {
    private Long id; // account id
    private String bankName; // 은행명
    private String accountName; // 계좌명
    private Long balance; // 잔고
    private List<TransactionInfo> transactions = new ArrayList<>();
}
