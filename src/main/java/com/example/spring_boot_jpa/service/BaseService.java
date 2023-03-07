package com.example.spring_boot_jpa.service;

import com.example.spring_boot_jpa.madel.ApiResponse;

public interface BaseService <T>{
    ApiResponse getList();
    ApiResponse add(T t);
}
