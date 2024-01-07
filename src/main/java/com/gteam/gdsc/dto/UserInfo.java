package com.gteam.gdsc.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfo {
    private LocalDate birthday; // 생년월일
    private Integer age; // 나이
    private String gender; // 성별
}
