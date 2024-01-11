package com.gteam.gdsc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_EMAIL", nullable = false)
    private String email;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @Column(name = "USER_PICTURE_URL", nullable = false)
    private String pictureUrl;

    @Column(name = "USER_TOKEN", columnDefinition = "TEXT")
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE", nullable = false)
    private Role role;

/*    @Column(name = "USER_BIRTHDAY", nullable = false)
    private LocalDate birthday;

    @Column(name = "USER_AGE", nullable = false)
    private Integer age;

    @Column(name = "USER_GENDER", nullable = false)
    private String gender;*/
}
