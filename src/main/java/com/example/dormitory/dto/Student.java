package com.example.dormitory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Student {
    private int id;
    private int identity;
    private String name;
    private String address;
    private String college;
    private String building;
    private int room;
    private String note="未注册";
    private String sex;
    private Date birthday;
    private String phone;
    private String nation;
    private String home;
    private String place;

}
