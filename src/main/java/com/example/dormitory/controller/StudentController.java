package com.example.dormitory.controller;

import com.example.dormitory.dto.Info;
import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.Student;
import com.example.dormitory.repository.StudentRepository;
import com.example.dormitory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/msg/{id}")
    public Response studentMsg(@PathVariable("id") int id){
        System.out.println(id);
        return studentService.studentMsg(id);
    }

    @PutMapping("/update/{id}")
    public Response editMsg(@RequestBody Student student){
        System.out.println(student);
        return studentService.editMsg(student);
    }

    @GetMapping("/room/{id}")
    public Response roommates(@PathVariable("id") int id){
        return studentService.roommates(id);
    }

}
