package com.user.UserServiceCapstone2025.repositories;

import com.user.UserServiceCapstone2025.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findByEmail(String email);


}
