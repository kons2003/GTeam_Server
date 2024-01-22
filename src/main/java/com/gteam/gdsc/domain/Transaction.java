package com.gteam.gdsc.domain;

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
}
