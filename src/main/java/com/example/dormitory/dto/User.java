package com.example.dormitory.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class User implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Integer admin = 0;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority user = new SimpleGrantedAuthority("ROLE_user");
        authorities.add(user);
        if (admin == 1) {
            SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ROLE_admin");
            authorities.add(admin);
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
