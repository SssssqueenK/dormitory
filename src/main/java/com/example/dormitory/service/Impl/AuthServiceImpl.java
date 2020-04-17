package com.example.dormitory.service.Impl;

import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.User;
import com.example.dormitory.repository.UserRepository;
import com.example.dormitory.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Response register(User user) {
        System.out.println(user.getUsername());
        int a = Integer.parseInt(user.getUsername());
        System.out.println(a);
        if(userRepository.existsAlready(user.getUsername())){
            return Response.error("该账号已经注册");
        }
        if(!userRepository.existsById(a)){
            return Response.error("该学号不存在");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        if(userRepository.insertUser(user)){
            return Response.success("注册成功");
        }else {
            return Response.error("注册失败，请重试");
        }
    }
}
