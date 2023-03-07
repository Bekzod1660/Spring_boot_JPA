package com.example.spring_boot_jpa.madel.dto;

import com.example.spring_boot_jpa.entity.UserEntity;
import lombok.Data;

@Data
public class LaptopRequestDto {
    private String madel;
    private String user;
}
