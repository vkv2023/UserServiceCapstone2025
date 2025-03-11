package com.user.UserServiceCapstone2025.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Token extends Base{

    private String value;
    private String expireAt;

    @ManyToOne
    private User user;
}

/*
User --- Token
1 ------ M
1 ----- 1
User : Token 1:M
*/
