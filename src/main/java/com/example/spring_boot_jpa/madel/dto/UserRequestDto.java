package com.example.spring_boot_jpa.madel.dto;

import com.example.spring_boot_jpa.entity.LaptopEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {
   private String name;
   private String phone_number;
   private List<LaptopEntity>laptopEntityList;
}
