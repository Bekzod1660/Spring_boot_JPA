package com.example.spring_boot_jpa.controller;

import com.example.spring_boot_jpa.madel.dto.LaptopRequestDto;
import com.example.spring_boot_jpa.madel.dto.UserRequestDto;
import com.example.spring_boot_jpa.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/laptop")
@RequiredArgsConstructor
public class LaptopController {
    private final LaptopService laptopService;
    @GetMapping("/list")
    public ResponseEntity<?> getUserList() {
        return ResponseEntity.ok(laptopService.getList());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(
            @RequestParam int id) {
        return ResponseEntity.ok(laptopService.delete(id));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUser(
            @RequestBody LaptopRequestDto laptopRequestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(laptopService.add(laptopRequestDto));
    }
}
