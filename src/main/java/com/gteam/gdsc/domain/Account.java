package com.gteam.gdsc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    
    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "BANK_NAME", nullable = false)
    private String bankName; // 은행명
    
    @Column(name = "ACCOUNT_NAME", nullable = false)
    private String accountName; // 계좌명
    
    @Column(name = "BALANCE", nullable = false)
    private Long balance; // 잔고
    
    

}
