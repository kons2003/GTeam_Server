package com.gteam.gdsc.service;

import com.gteam.gdsc.domain.User;
import com.gteam.gdsc.dto.UserInfo;
import com.gteam.gdsc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 유저 생성
    @Transactional
    public String createUser(UserInfo userInfo) {
        User user = User.builder()
                .email(userInfo.getEmail())
                .verifiedEmail(userInfo.getVerifiedEmail())
                .name(userInfo.getName())
                .pictureUrl(userInfo.getPictureUrl())
                .locale(userInfo.getLocale())
                .birthday(userInfo.getBirthday())
                .gender(userInfo.getGender())
                .build();
        userRepository.save(user);
        return "유저 정보 추가 성공";
    }

    // 유저 정보 불러오기
    public User findUserByName(String userName) {
        return userRepository.findUserByName(userName)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 유저명 입니다."));
    }

    public User findUserById(Long userId) {
        return userRepository.findUserById(userId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 유저 ID 입니다."));
    }

    // 유저 수정
    @Transactional
    public String updateUser(UserInfo userInfo) {
        User user = userRepository.findUserById(userInfo.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 유저명 입니다."));
        user.update(User.builder()
                .id(userInfo.getId())
                .email(userInfo.getEmail())
                .verifiedEmail(userInfo.getVerifiedEmail())
                .name(userInfo.getName())
                .pictureUrl(userInfo.getPictureUrl())
                .locale(userInfo.getLocale())
                .birthday(userInfo.getBirthday())
                .gender(userInfo.getGender())
                .build());
        return "유저 수정 성공";
    }

    // 유저 삭제
    @Transactional
    public String deleteUser(UserInfo userIdDto, UserInfo userNameDto) {
        Stream<User> user = Stream.<User>builder()
                .add(findUserById(userIdDto.getId()))
                .add(findUserByName(userNameDto.getName()))
                .build();
        userRepository.delete((User) user);
        return "유저 삭제 성공";
    }
}
