package com.example.dormitory.dto;

import lombok.Data;

@Data
public class Room {
    private int id;
    private String address;
    private String building;
    private int room;
    private String type;
    private int num;
}
