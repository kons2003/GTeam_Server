package com.gteam.gdsc.domain;

import com.gteam.gdsc.dto.TransactionInfo;
import com.gteam.gdsc.dto.UserInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_EMAIL", nullable = false)
    private String email; // 이메일

    @Column(name = "USER_VERIFIED_EMAIL", nullable = false)
    private Boolean verifiedEmail; // 검증된 이메일

    @Column(name = "USER_NAME", nullable = false)
    private String name; // 이름

    @Column(name = "USER_PICTURE_URL", nullable = false)
    private String pictureUrl; // 프로필 이미지

    @Column(name = "USER_LOCALE", nullable = false)
    private String locale; // 국가

    @Column(name = "USER_BIRTHDAY", nullable = false)
    private LocalDate birthday; // 생년월일

    @Column(name = "USER_GENDER", nullable = false)
    private String gender; // 성별

    @OneToMany(mappedBy = "user")
    @Column(name = "USER_TRANSACTIONS")
    private List<Transaction> transactions = new ArrayList<>();

    public UserInfo toUserInfo() {
        List<TransactionInfo> transactionInfos = transactions.stream().map(Transaction::toUserInfo).toList();
        return UserInfo.builder()
                .id(this.id)
                .email(this.email)
                .verifiedEmail(this.verifiedEmail)
                .name(this.name)
                .pictureUrl(this.pictureUrl)
                .locale(this.locale)
                .birthday(this.birthday)
                .gender(this.gender)
                .transactions(transactionInfos)
                .build();
    }

    public void update(User user) {
        this.id = user.id;
        this.email = user.email;
        this.verifiedEmail = user.verifiedEmail;
        this.name = user.name;
        this.pictureUrl = user.pictureUrl;
        this.locale = user.locale;
        this.birthday = user.birthday;
        this.gender = user.gender;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public String getName() {
        return this.name;
    }
}

