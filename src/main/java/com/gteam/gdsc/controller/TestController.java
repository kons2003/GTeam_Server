package com.gteam.gdsc.controller;

import com.gteam.gdsc.domain.User;
import com.gteam.gdsc.service.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final AuthService authService;

    @GetMapping("/test")
    @ApiOperation(value = "테스트", notes = "테스트 중입니다.")
    public User test(Principal principal) {
        return authService.test(principal);
    }
}