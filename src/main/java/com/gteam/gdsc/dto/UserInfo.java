package com.gteam.gdsc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfo {
    @ApiModelProperty(value = "생년월일")
    private LocalDate birthday; // 생년월일
    @ApiModelProperty(value = "나이")
    private Integer age; // 나이
    @ApiModelProperty(value = "성별")
    private String gender; // 성별
}