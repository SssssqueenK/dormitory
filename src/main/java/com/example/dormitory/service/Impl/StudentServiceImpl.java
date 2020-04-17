package com.example.dormitory.service.Impl;

import com.example.dormitory.dto.Info;
import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.Student;
import com.example.dormitory.repository.StudentRepository;
import com.example.dormitory.repository.UserRepository;
import com.example.dormitory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public Response insert(Student student) {
        int id = student.getIdentity();
        if(studentRepository.existStudent(id)){
            return Response.error("学号已存在");
        }
        studentRepository.insert(student);
        System.out.println(student.getId());
        return Response.success(student);
    }

    @Override
    public Response update(Student student) {
        studentRepository.update(student);
        return Response.success();
    }

    @Override
    public Response get(int id) {
        return Response.success(studentRepository.getStudentByIdentity(id));
    }

    @Override
    public Response getAll() {
        return Response.success(studentRepository.getAllStudents());
    }

    @Override
    public Response delete(int id) {
        studentRepository.delete(id);
        return Response.success();
    }

    @Override
    public Response getByAddr(String addr) {
        List<Student> students = studentRepository.getStudentsByAddr(addr);
        for (Student i:students) {
            String username = String.valueOf(i.getIdentity());
            if(userRepository.existsAlready(username)){
                i.setNote("已注册");
            }
        }
        return Response.success(students);
    }

    @Override
    public Response studentMsg(int id) {
        return Response.success(studentRepository.getStudentByIdentity(id));
    }

    @Override
    public Response editMsg(Student student) {
        studentRepository.msgEdit(student);
        return Response.success();
    }

    @Override
    public Response roommates(int id) {
        String a = studentRepository.getAddByIdentity(id);
        String b = studentRepository.getBuildingByIdentity(id);
        int c = studentRepository.getRoomByIdentity(id);
        return Response.success(studentRepository.roommates(a,b,c));
    }
}
