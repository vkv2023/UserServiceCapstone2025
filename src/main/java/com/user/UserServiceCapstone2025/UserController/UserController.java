package com.user.UserServiceCapstone2025.UserController;

import com.user.UserServiceCapstone2025.dto.*;
import com.user.UserServiceCapstone2025.models.Token;
import com.user.UserServiceCapstone2025.models.User;
import com.user.UserServiceCapstone2025.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public SignupResponseDto signUp(@RequestBody SignupRequestDto signupRequestDto)
    {
        User user = userService.signUp(signupRequestDto.getName(),
                signupRequestDto.getPassword(),
                signupRequestDto.getEmail());
        return SignupResponseDto.from(user);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        Token token = userService.login(loginRequestDto.getEmail(),
                loginRequestDto.getPassword());
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setTokenValue(token.getValue());
        return loginResponseDto;
    }

   @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto logoutRequestDto)
   {
//       Put the logout logic here
//       by marking the record deleted flag as true
        return null;

    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<Boolean> validateToken(@PathVariable("token") String token)
    {
        User user = userService.validateToken(token);
        ResponseEntity<Boolean> responseEntity;

        if (user == null){
            responseEntity = new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
        else {
            responseEntity = new ResponseEntity<>(true, HttpStatus.OK);
        }
        return responseEntity;
    }
}
