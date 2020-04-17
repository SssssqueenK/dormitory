package com.example.dormitory.repository;

import com.example.dormitory.dto.Info;
import com.example.dormitory.dto.Room;
import com.example.dormitory.dto.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentRepository {

    @Insert("insert into student (identity, name, address,college, building, room,sex) values (#{identity},#{name},#{address},#{college},#{building},#{room},#{sex})")
    @Options(keyProperty = "id",keyColumn = "id",useGeneratedKeys = true)
    boolean insert(Student student);

    @Update("update student set identity = #{identity},name=#{name},college=#{college},building= #{building},room = #{room},sex=#{sex} where id = #{id}")
    boolean update(Student student);

    @Select("select * from student where identity = #{id}")
    Student getStudentByIdentity(int id);

    @Select("select * from student")
    List<Student> getAllStudents();

    @Delete("delete from student where id=#{id}")
    boolean delete(int id);

    @Select("select *from student where address=#{addr}")
    List<Student> getStudentsByAddr(String addr);

    @Select("select * from student where address=#{address} and building=#{building} and room=#{room}")
    List<Student> getStudentsByRooms(String address,String building,int room);

    @Select("select count(*) from student where address=#{address} and building=#{building} and room=#{room}")
    int num(Room room);

    @Update("update student set birthday=#{birthday},phone=#{phone},nation=#{nation},home=#{home},place=#{place} where identity=#{identity}")
    boolean msgEdit(Student student);

    @Select("select address from student where identity=#{identity}")
    String getAddByIdentity(int identity);

    @Select("select building from student where identity=#{identity}")
    String getBuildingByIdentity(int identity);

    @Select("select room from student where identity=#{identity}")
    int  getRoomByIdentity(int identity);

    @Select("select identity, name, college,address,building,room from student where address=#{address} and building=#{building} and room=#{room}")
    List<Student> roommates(String address,String building,int room);

    @Select("select ifnull((select 1 from student where identity=#{id}),0)")
    boolean existStudent(int id);


}
