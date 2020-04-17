package com.example.dormitory.service.Impl;

import com.example.dormitory.dto.User;
import com.example.dormitory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("账户[" + s + "]未注册");
        }
        return user;
    }
}
