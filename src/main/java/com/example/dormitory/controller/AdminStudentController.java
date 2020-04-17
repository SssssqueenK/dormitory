package com.example.dormitory.controller;

import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.Student;
import com.example.dormitory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminStudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public Response getAll() {
        return studentService.getAll();
    }

    @GetMapping("/student/{id}")
    public Response getStudent(@PathVariable("id") int id) {
        return studentService.get(id);
    }

    @PostMapping("/student")
    public Response newStudent(@RequestBody Student student) {
        return studentService.insert(student);
    }

    @PutMapping("/student")
    public Response update(@RequestBody Student student) {
        System.out.println(student);
        return studentService.update(student);
    }

    @DeleteMapping("/student/{id}")
    public Response delete(@PathVariable("id") int id){
        return studentService.delete(id);
    }

    @GetMapping("/studentByAddr/{addr}")
    public Response studentByAddr(@PathVariable("addr") String addr){
        return studentService.getByAddr(addr);
    }
}
