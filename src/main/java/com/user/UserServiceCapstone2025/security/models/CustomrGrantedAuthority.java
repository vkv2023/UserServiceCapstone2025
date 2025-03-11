package com.user.UserServiceCapstone2025.security.models;

import com.user.UserServiceCapstone2025.models.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomrGrantedAuthority implements GrantedAuthority {

//    Role role; to avoid JACKSON issue.

    String authority;

    public String CustomGrantedAuthority(Role role){
//          return authority = role.getValue();
        return null;
    }


    @Override
    public String getAuthority() {
        return "";
    }
}
