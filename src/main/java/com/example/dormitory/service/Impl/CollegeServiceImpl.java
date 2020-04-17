package com.example.dormitory.service.Impl;

import com.example.dormitory.dto.College;
import com.example.dormitory.dto.Response;
import com.example.dormitory.repository.CollegeRepository;
import com.example.dormitory.service.CollegeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    CollegeRepository collegeRepository;

    @Override
    public Response newCollege(College college) {
        if(collegeRepository.existByCollegeByIdentity(college.getIdentity())||collegeRepository.existByCollegeByName(college.getName())){
            return Response.error("创建学院失败，请检查学院是否已经存在或重试");
        } else {
            collegeRepository.insertCollege(college);
            return Response.success();
        }
    }

    @Override
    public Response updateCollege(College college) {
        try{
            collegeRepository.updateCollege(college);
            return Response.success("修改成功");
        }catch (Exception e){
            return Response.error("修改失败，请检查学院编号和名称是否唯一");
        }
    }

    @Override
    public Response findCollegeByIdentity(String identity) {
        return Response.success(collegeRepository.findCollegeByIdentity(identity));
    }

    @Override
    public Response getAll() {
//        PageHelper.startPage(page,size);
//        Page<College> colleges = (Page<College>) collegeRepository.getAll(page,size);
//        PageInfo<College> pageInfo = new PageInfo<> (colleges);
//        pageInfo.setPageNum(page);
//        pageInfo.setPageSize(size);
//        System.out.println(pageInfo.getTotal());
//        System.out.println(colleges);
        return Response.success(collegeRepository.getAll());
    }

    @Override
    public Response deleteCollege(int id) {
        collegeRepository.deleteCollege(id);
        return Response.success();
    }

    @Override
    public Response findCollegeById(int id) {
        College college = collegeRepository.findCollegeById(id);
        System.out.println(college);
        return Response.success(college);
    }

    @Override
    public Response choseColleges(String addr) {
        return Response.success(collegeRepository.choseColleges(addr));
    }

}
