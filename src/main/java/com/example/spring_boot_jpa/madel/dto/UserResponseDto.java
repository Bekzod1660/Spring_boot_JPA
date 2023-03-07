package com.example.spring_boot_jpa.madel.dto;

import com.example.spring_boot_jpa.entity.LaptopEntity;
import lombok.Builder;
import lombok.Data;

import javax.sound.sampled.Line;
import java.util.List;

@Data
@Builder
public class UserResponseDto {
    private int id;
    private String name;
    private String phone_number;
    private List<LaptopEntity> laptopEntity;
}
