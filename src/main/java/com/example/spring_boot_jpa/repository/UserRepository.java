package com.example.spring_boot_jpa.repository;

import com.example.spring_boot_jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity>findByPhoneNumber(String phoneNumber);
    void deleteById(int id);
    UserEntity findById(int id);

}
