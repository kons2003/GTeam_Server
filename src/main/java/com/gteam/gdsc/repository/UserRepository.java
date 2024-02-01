package com.gteam.gdsc.repository;

import com.gteam.gdsc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long userId);
    Optional<User> findByEmail(String userEmail);
    Optional<User> findUserByName(String userName);
}