package com.gteam.gdsc.controller;

import com.gteam.gdsc.dto.UserInfo;
import com.gteam.gdsc.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "UserController")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/new")
    @Operation(description = "신규 회원 정보 추가")
    public ResponseEntity<String> createUser(@RequestBody UserInfo userInfo) {
        return ResponseEntity.ok(userService.createUser(userInfo));
    }

    @GetMapping("/{name}")
    @Operation(description = "회원 조회")
    public ResponseEntity<UserInfo> findUserByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(userService.findUserByName(name).toUserInfo());
    }

    @PutMapping
    @Operation(description = "회원 정보 수정")
    public ResponseEntity<String> updateUser(@RequestBody UserInfo userInfo) {
        return ResponseEntity.ok(userService.updateUser(userInfo));
    }

    @DeleteMapping
    @Operation(description = "회원 정보 삭제")
    public ResponseEntity<String> deleteUser(@RequestBody UserInfo userIdInfo, UserInfo userNameInfo) {
        return ResponseEntity.ok(userService.deleteUser(userIdInfo, userNameInfo));
    }

}
