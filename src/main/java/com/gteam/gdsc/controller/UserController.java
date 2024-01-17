/*
package com.gteam.gdsc.controller;

import com.gteam.gdsc.domain.User;
import com.gteam.gdsc.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@Tag(name = "UserController")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    // CREATE
    @Operation(description = "신규 회원 정보 추가 입력")
    @PostMapping("/new")
    public ResponseEntity<String> userInfo(@Parameter @RequestBody User user) {
        return ResponseEntity.ok(userService.addUserInformation(user));
    }

    // READ
    @Operation(description = "회원 조회")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@Parameter @PathVariable("id") String id) {
        return ResponseEntity.ok(userService.findByUserId);
    }

    // UPDATE
    @Operation(description = "회원 정보 수정")
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@Parameter @PathVariable("id") @RequestBody String id) {
        return ResponseEntity.ok(userService.findByUserId);
    }

    // DELETE

}
*/
