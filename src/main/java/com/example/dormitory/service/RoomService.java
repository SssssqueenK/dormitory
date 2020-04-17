package com.example.dormitory.service;

import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.Room;

public interface RoomService {
    Response insert(Room room);
    Response delete(int id);
    Response getAll();
    Response getBuildings(String addr);
    Response choseRooms(String address,String building,String sex);
    Response choseStudents(String a,String b,int c);

}
