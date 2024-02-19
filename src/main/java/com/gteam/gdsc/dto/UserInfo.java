package com.gteam.gdsc.dto;

import com.gteam.gdsc.dto.TransactionInfo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserInfo {
    private Long id;
    private String email; // 이메일
    private Boolean verifiedEmail; // 검증된 이메일
    private String name; // 이름
    private String pictureUrl; // 프로필 이미지
    private String locale; // 국가
    private LocalDate birthday; // 생년월일
    private String gender; // 성별
    private List<TransactionInfo> transactions = new ArrayList<>();
}
