package com.gteam.gdsc.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionInfo {
    private Long transactionId; // transaction id
    private String transactionName; // 거래명
    private LocalDateTime useDateTime; // 사용 날짜, 시간
    private String useType; // 구분(수입, 지출 등)

    private String depositDestination; // 입금처
    private String incomeCategory; // 소득 분야
    private Long incomeAmount; // 소득 금액
    private Long monthlyIncome; // 한 달 소득 금액

    private String withdrawalDestination; // 출금처
    private String expenditureCategory; // 지출 분야
    private Long expenditureAmount; // 지출 금액
    private Long monthlyExpenditure; // 한 달 지출 금액

    private String userName;
    private String accountName;
}
