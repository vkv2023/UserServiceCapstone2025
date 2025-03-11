package com.user.UserServiceCapstone2025.repositories;

import com.user.UserServiceCapstone2025.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Token save(Token token);

    Optional<Token> findByValueAndDeletedAndExpireAtGreaterThan
            (String Value,
             boolean deleted,
             String expireAt);
//             Date expiryDate);
}
