package com.example.dormitory.service.Impl;

import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.Room;
import com.example.dormitory.repository.RoomRepository;
import com.example.dormitory.repository.StudentRepository;
import com.example.dormitory.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Response insert(Room room) {
        if(roomRepository.exist(room)){
            return Response.error("添加失败，该房间是否已经存在");
        }
        else{
            roomRepository.insert(room);
            return Response.success();
        }
    }

    @Override
    public Response delete(int id) {
        roomRepository.delete(id);
        return Response.success();
    }

    @Override
    public Response getAll() {
        List<Room> rooms = roomRepository.getAll();
        for (Room room:rooms) {
            room.setNum(studentRepository.num(room));
        }
        return Response.success(rooms);
    }

    @Override
    public Response getBuildings(String addr) {
        return Response.success(roomRepository.getBuildings(addr));
    }

    @Override
    public Response choseRooms(String address, String building,String sex) {
        System.out.println(sex);
        String type ="男生宿舍";
        String test ="女";
        if(sex.equals(test)){
            type="女生宿舍";
        }
        System.out.println(type);
        return Response.success(roomRepository.chooseRooms(address,building,type));
    }

    @Override
    public Response choseStudents(String a,String b,int c) {
        return Response.success(studentRepository.getStudentsByRooms(a,b,c));
    }
}
