package com.example.spring_boot_jpa.controller;

import com.example.spring_boot_jpa.madel.dto.UserRequestDto;
import com.example.spring_boot_jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")

public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<?> getUserList() {
        return ResponseEntity.ok(userService.getList());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(
             @RequestBody UserRequestDto userRequestDto
    ) {

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.add(userRequestDto));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(
            @RequestParam int id) {
        return ResponseEntity.ok(userService.delete(id));
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(
            @RequestParam int oldId,
            @RequestBody UserRequestDto userRequestDto
    ){
        return ResponseEntity.ok(userService.update(oldId,userRequestDto));
    }
}
