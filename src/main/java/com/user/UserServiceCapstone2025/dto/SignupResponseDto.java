package com.user.UserServiceCapstone2025.dto;

import com.user.UserServiceCapstone2025.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {

    private String name;
    private String email;
    //  using password for testing purposes. Never use send the password back in dto
    private String password;


    public static SignupResponseDto from(User user){
        if (user == null){
            return null;
        }
        SignupResponseDto signupResponseDto = new SignupResponseDto();
        signupResponseDto.setName(user.getName());
        signupResponseDto.setEmail(user.getEmail());
        signupResponseDto.setPassword(user.getPassword());
        return signupResponseDto;
    }
}
