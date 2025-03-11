package com.user.UserServiceCapstone2025.security.models;

import com.user.UserServiceCapstone2025.models.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

//    Role role; to avoid JACKSON issue.

    String authority;

    public CustomGrantedAuthority(Role role){
          this.authority = role.getValue();
    }


    @Override
    public String getAuthority() {
        return authority;
    }
}
