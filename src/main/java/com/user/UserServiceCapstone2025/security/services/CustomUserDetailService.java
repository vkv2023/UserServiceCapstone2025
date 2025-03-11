package com.user.UserServiceCapstone2025.security.services;

import com.user.UserServiceCapstone2025.models.User;
import com.user.UserServiceCapstone2025.repositories.UserRepository;
import com.user.UserServiceCapstone2025.security.models.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    //To Load the data use User Repository
    UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        User user = optionalUser.get();
//        Not Allowed since UserDetails is an Interface and we can't create from ()
//        Also we don't modify our User
//        return UserDetails.from(user);

//        We'll use a wrapper to create a wrapper in UserDetails,and return the wrapper the same.
          return new CustomUserDetails(user);
    }
}
