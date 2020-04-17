package com.example.dormitory;

import com.example.dormitory.dto.College;
import com.example.dormitory.dto.User;
import com.example.dormitory.repository.CollegeRepository;
import com.example.dormitory.repository.RoomRepository;
import com.example.dormitory.repository.UserRepository;
import com.example.dormitory.service.AuthService;
import com.example.dormitory.service.CollegeService;
import com.example.dormitory.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DormitoryApplicationTests {
    @Autowired
    CollegeService collegeService;
    @Autowired
    CollegeRepository collegeRepository;
    @Autowired
    AuthService authService;
    @Autowired
    RoomService roomService;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
//        collegeService.getAll(1,3);
    }


}
