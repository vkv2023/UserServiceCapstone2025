package com.user.UserServiceCapstone2025.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.random.RandomGenerator;
import com.user.UserServiceCapstone2025.models.Token;
import com.user.UserServiceCapstone2025.models.User;
import com.user.UserServiceCapstone2025.repositories.TokenRepository;
import com.user.UserServiceCapstone2025.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;



public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    // Using this to encrypt the password before saving
    BCryptPasswordEncoder bCryptPasswordEncoder;

    TokenRepository tokenRepository;


    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public User signUp(String name, String email, String password) {
//  For Signup we need name, email, password, encrypt the password,
//        and save the details in the databases
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    @Override
    public Token login(String email, String password) {
//      We need to check if user exists, check the password supplied by th user
//      create a token and return the same to user. also, set token expiry time
//       save the token in database.

        Optional<User> optionalUSer = userRepository.findByEmail(email);
        if (optionalUSer.isEmpty()) {
//            Throw exception or redirect to log in or both
            return null;
        }
        User user = optionalUSer.get();
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return null;
        }
        Token token = new Token();
        token.setUser(user);
//        Onw way of generating the token
//        Its by default 128 bits
        token.setValue(UUID.randomUUID().toString());
//        Check why RandomStringUtils.randomAlphanumeric(count(128)) is not working
//        token.setValue(RandomS);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        Date date = calendar.getTime();

        token.setExpireAt(String.valueOf(date));

        return tokenRepository.save(token);
    }

    @Override
    public void logout(String tokenValue) {

    }

    @Override
    public User validateToken(String tokenValue) {
//  1- Token should be in DB
//  2- Token should not be deleted.
//  3- Token should not be expired.

        // Get the current date
        Date currentDate = new Date();

        // Define the date format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Convert the current date to a string
        String dateString = formatter.format(currentDate);
        Optional<Token> optionalToken = tokenRepository
                .findByValueAndDeletedAndExpireAtGreaterThan(tokenValue,
                false, dateString);

        if (optionalToken.isEmpty()) {
            return null;
        }
//      validate the token for the user
      return optionalToken.get().getUser();
    }
}
