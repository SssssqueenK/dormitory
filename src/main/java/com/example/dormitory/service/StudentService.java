package com.example.dormitory.service;

import com.example.dormitory.dto.Info;
import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.Student;

public interface StudentService {
    //管理员
    Response insert(Student student);
    Response update(Student student);
    Response get(int id);
    Response getAll();
    Response delete(int id);
    Response getByAddr(String addr);
    //学生端
    Response studentMsg(int id);
    Response editMsg(Student student);
    Response roommates(int id);
}

