package com.gteam.gdsc.dto;

import lombok.Data;

@Data
public class AccountInfo {
    private Long accountId; // account id
    private String bankName; // 은행명
    private String accountName; // 계좌명
    private Long balance; // 잔고
}
