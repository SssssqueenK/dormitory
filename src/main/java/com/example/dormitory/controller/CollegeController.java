package com.example.dormitory.controller;

import com.example.dormitory.dto.College;
import com.example.dormitory.dto.Response;
import com.example.dormitory.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @PostMapping("/newCollege")
    public Response college(@Valid @RequestBody College college){
        return collegeService.newCollege(college);
    }

    @PutMapping("/updateCollege")
    public Response updateCollege(@RequestBody College college){
        return collegeService.updateCollege(college);
    }

    @GetMapping("/select")
    public Response selectCollege(){
        return collegeService.findCollegeByIdentity("cst");
    }

    @GetMapping("/getCollege")
    public Response getAll() {
        return collegeService.getAll();
    }

    @DeleteMapping("/deleteCollege/{id}")
    public Response deleteCollege(@PathVariable("id") int id){
        return collegeService.deleteCollege(id);
    }

    @GetMapping("/getSetting/{id}")
    public Response getSetting(@PathVariable("id") int id){
        return collegeService.findCollegeById(id);
    }

    @GetMapping("/choseColleges/{addr}")
    public Response choseColleges(@PathVariable("addr") String addr){
        return collegeService.choseColleges(addr);
    }
}
