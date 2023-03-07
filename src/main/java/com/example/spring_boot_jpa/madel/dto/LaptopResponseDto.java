package com.example.spring_boot_jpa.madel.dto;

import com.example.spring_boot_jpa.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LaptopResponseDto {
    private int id;
    private String madel;
    private String user;
}
