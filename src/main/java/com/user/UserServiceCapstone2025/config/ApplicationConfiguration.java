package com.user.UserServiceCapstone2025.config;

import com.user.UserServiceCapstone2025.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }


    /*
//    @Bean
//    public UserService userService() {
////        return new UserService();
//        return null;
//    }
*/

}
