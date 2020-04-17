package com.example.dormitory.repository;

import com.example.dormitory.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {
    @Insert("insert into user(username, password) values (#{username},#{password})")
    boolean insertUser(User user);

    @Select("select ifnull((select 1 from user where username = #{username}), 0)")
    boolean existsAlready(String username);

    @Select("select ifnull((select 1 from student where identity=#{username}), 0)")
    boolean existsById(int id);

    @Select("select *from user where username = #{username}")
    User getByUsername(String username);
}