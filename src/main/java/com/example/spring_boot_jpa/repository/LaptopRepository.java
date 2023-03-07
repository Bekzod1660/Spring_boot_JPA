package com.example.spring_boot_jpa.repository;

import com.example.spring_boot_jpa.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity,Integer> {
    Optional<LaptopEntity>findByMadel(String name);
}
