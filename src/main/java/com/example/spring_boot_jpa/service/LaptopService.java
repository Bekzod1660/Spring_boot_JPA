package com.example.spring_boot_jpa.service;

import com.example.spring_boot_jpa.entity.LaptopEntity;
import com.example.spring_boot_jpa.entity.UserEntity;
import com.example.spring_boot_jpa.madel.ApiResponse;
import com.example.spring_boot_jpa.madel.ResponseMessage;
import com.example.spring_boot_jpa.madel.dto.LaptopRequestDto;
import com.example.spring_boot_jpa.madel.dto.LaptopResponseDto;
import com.example.spring_boot_jpa.repository.LaptopRepository;
import com.example.spring_boot_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LaptopService implements BaseService<LaptopRequestDto> {
    private final LaptopRepository laptopRepository;
    private final UserRepository userRepository;

    @Override
    public ApiResponse getList() {

        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatusCode(),
                ResponseMessage.SUCCESS.getMassage(),
                laptopRepository.findAll().stream().map((this::getLaptopDto))
        );
    }

    @Override
    public ApiResponse add(LaptopRequestDto laptopRequestDto) {
        ApiResponse apiResponse;
        Optional<LaptopEntity> laptopEntity =
                laptopRepository.findByMadel(laptopRequestDto.getMadel());
        if (laptopEntity.isPresent()) {
            apiResponse = new ApiResponse(
                    ResponseMessage.ERROR_USER_ALREADY_EXIST.getStatusCode(),
                    ResponseMessage.ERROR_USER_ALREADY_EXIST.getMassage()
            );
        } else {
            final LaptopEntity laptop = new LaptopEntity(laptopRequestDto.getMadel(), getUserByName(laptopRequestDto.getUser()));

            laptopRepository.save(laptop);
            apiResponse = new ApiResponse(
                    ResponseMessage.SUCCESS.getStatusCode(),
                    ResponseMessage.SUCCESS.getMassage()
            );
        }

        return apiResponse;
    }

    private UserEntity getUserByName(String name) {
        for (UserEntity userEntity : userRepository.findAll()) {
            if (userEntity.getName().equals(name)) {
                return userEntity;
            }
        }
        return null;
    }

    public LaptopResponseDto getLaptopDto(LaptopEntity laptopEntity) {
        return LaptopResponseDto.builder()
                .madel(laptopEntity.getMadel())
                .user(laptopEntity.getUserEntity().getName()).build();
    }

    private LaptopEntity laptop(int id) {
        for (LaptopEntity laptop : laptopRepository.findAll()) {
            if (laptop.getId() == id) {
                return laptop;
            }
        }
        return null;
    }

    public Object delete(int id) {
        laptopRepository.delete(laptop(id));
        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatusCode(),
                ResponseMessage.SUCCESS.getMassage()

        );
    }
}
