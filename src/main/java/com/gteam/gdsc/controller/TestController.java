package com.gteam.gdsc.controller;

import com.gteam.gdsc.auth.domain.GoogleUser;
import com.gteam.gdsc.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Tag(name = "test API", description = "Swagger 테스트 컨트롤러")
@RestController
@RequiredArgsConstructor
public class TestController {
    private final AuthService authService;

    @GetMapping("/api/hello")
    public String test() {
        return "hello";
    }

    @Operation(summary = "구글 로그인", description = "test 메소드 실행")
    @Parameter(name = "principal", description = "test")
    @GetMapping("/test")
    public GoogleUser test(Principal principal) {
        return authService.test(principal);
    }


}