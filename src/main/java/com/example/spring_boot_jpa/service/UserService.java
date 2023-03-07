package com.example.spring_boot_jpa.service;

import com.example.spring_boot_jpa.entity.UserEntity;
import com.example.spring_boot_jpa.madel.ApiResponse;
import com.example.spring_boot_jpa.madel.ResponseMessage;
import com.example.spring_boot_jpa.madel.dto.UserRequestDto;
import com.example.spring_boot_jpa.madel.dto.UserResponseDto;
import com.example.spring_boot_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserRequestDto> {
    private final UserRepository userRepository;

    @Override
    public ApiResponse getList() {
        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatusCode(),
                ResponseMessage.SUCCESS.getMassage(),
                userRepository.findAll().stream().map(this::grtUserDto).toList()
        );
    }

    @Override
    public ApiResponse add(UserRequestDto userRequestDto) {
        ApiResponse apiResponse;
        final Optional<UserEntity> optionalUser
                = userRepository.findByPhoneNumber(userRequestDto.getPhone_number());

        if (optionalUser.isPresent()) {
            apiResponse = new ApiResponse(
                    ResponseMessage.ERROR_USER_ALREADY_EXIST.getStatusCode(),
                    ResponseMessage.ERROR_USER_ALREADY_EXIST.getMassage()
            );
        } else {
            final UserEntity userEntity = new UserEntity(
                    userRequestDto.getName(),
                    userRequestDto.getPhone_number(),
                    userRequestDto.getLaptopEntityList()
            );
            userRepository.save(userEntity);
            apiResponse = new ApiResponse(
                    ResponseMessage.SUCCESS.getStatusCode(),
                    ResponseMessage.SUCCESS.getMassage()

            );
        }
        return apiResponse;
    }

    public ApiResponse delete(int id) {
        userRepository.deleteById(id);
        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatusCode(),
                ResponseMessage.SUCCESS.getMassage()

        );

    }

    private UserEntity getUserEntity(int userId,UserRequestDto u){
        UserEntity userEntity = new UserEntity(u.getName(), u.getPhone_number(), u.getLaptopEntityList());
        userEntity.setId(userId);
        return userEntity;
    }

    private UserResponseDto grtUserDto(UserEntity userEntity) {
        return UserResponseDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .phone_number(userEntity.getPhoneNumber())
                .laptopEntity(userEntity.getLaptopEntityList()).build();
    }

    public ApiResponse update(int id,UserRequestDto user){
        UserEntity userEntity = getUserEntity(id, user);
        userRepository.save(userEntity);
        return new ApiResponse(
                ResponseMessage.SUCCESS.getStatusCode(),
                ResponseMessage.SUCCESS.getMassage()
        );
    }

}
