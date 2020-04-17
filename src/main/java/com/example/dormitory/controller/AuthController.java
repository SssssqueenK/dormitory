package com.example.dormitory.controller;

import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.User;
import com.example.dormitory.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public Response register(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return Response.error(error.getDefaultMessage());
            }
        }
        System.out.println(user);
        return authService.register(user);
    }
}
