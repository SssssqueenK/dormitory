package com.example.dormitory.controller;

import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.Room;
import com.example.dormitory.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class RoomController {
    @Autowired
    RoomService roomService;

    @PostMapping("/room")
    public Response newRoom(@RequestBody Room room) {
        return roomService.insert(room);
    }

    @DeleteMapping("/room/{id}")
    public Response delete(@PathVariable("id") int id) {
        return roomService.delete(id);
    }

    @GetMapping("/rooms")
    public Response get() {
        return roomService.getAll();
    }

    @GetMapping("/buildings/{addr}")
    public Response getBuildings(@PathVariable("addr") String addr) {
        return roomService.getBuildings(addr);
    }

    @GetMapping("/build")
    public Response chooseRooms(@RequestParam("a") String a,@RequestParam("b") String b,@RequestParam("c") String c){
        return roomService.choseRooms(a,b,c);
    }

    @GetMapping("/choseStudents")
    public Response choseStudents(@RequestParam("a") String a,@RequestParam("b") String b,@RequestParam("c") int c){
        return roomService.choseStudents(a,b,c);
    }

}
