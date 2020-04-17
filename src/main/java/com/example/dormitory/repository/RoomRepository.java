package com.example.dormitory.repository;

import com.example.dormitory.dto.Room;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoomRepository {
    @Insert("insert into room (address, building, room, type) VALUES (#{address},#{building},#{room},#{type})")
    boolean insert(Room room);

    @Delete("delete from room where id=#{id}")
    boolean delete(int id);

    @Select("select * from room")
    List<Room> getAll();

    @Select("select ifnull((select 1 from room where address=#{address} and building=#{building} and room=#{room}),0)")
    boolean exist(Room room);

    @Select("select distinct building from room where address = #{addr}")
    List<String> getBuildings(String addr);

    @Select("select room from room where address=#{address} and building=#{building} and type=#{type}")
    List<Integer> chooseRooms(String address,String building,String type);


}
