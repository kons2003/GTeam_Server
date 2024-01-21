package com.gteam.gdsc.repository;

import com.gteam.gdsc.auth.domain.GoogleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<GoogleUser, Long> {
    Optional<GoogleUser> findByEmail(String userEmail);
}