package com.example.dormitory.service;


import com.example.dormitory.dto.College;
import com.example.dormitory.dto.Response;

public interface CollegeService {
    Response newCollege(College college);
    Response updateCollege(College college);
    Response findCollegeByIdentity(String identity);
    Response getAll();
    Response deleteCollege(int id);
    Response findCollegeById(int id);
    Response choseColleges(String addr);
}
