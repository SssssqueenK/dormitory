package com.example.dormitory.service;

import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.User;

public interface AuthService {
    Response register(User user);

}
