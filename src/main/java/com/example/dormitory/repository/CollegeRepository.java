package com.example.dormitory.repository;

import com.example.dormitory.dto.College;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CollegeRepository {
    @Insert("insert into college (identity, name, person, address, num) values (#{identity},#{name},#{person},#{address},#{num})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    boolean insertCollege(College college);

    @Update("update college set identity = #{identity}," +
            "name = #{name},person = #{person}," +
            "address = #{address},num = #{num} where id=#{id}")
    boolean updateCollege(College college);

    @Select("select * from college where identity = #{identity}")
    College findCollegeByIdentity(String identity);


    @Select("select * from college where id = #{id}")
    College findCollegeById(int id);

    @Delete("delete from college where id = #{id}")
    boolean deleteCollege(int id);

    @Select("select *from college")
    List<College> getAll();

    @Select("select ifnull((select 1 from college where identity = #{identity}),0)")
    boolean existByCollegeByIdentity(String identity);

    @Select("select ifnull((select 1 from college where name = #{name}),0)")
    boolean existByCollegeByName(String identity);

    @Select("select name from college where address=#{addr}")
    List<String> choseColleges(String addr);
}
