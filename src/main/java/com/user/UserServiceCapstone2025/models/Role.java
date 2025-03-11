package com.user.UserServiceCapstone2025.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role extends Base{

    private String value;
}
