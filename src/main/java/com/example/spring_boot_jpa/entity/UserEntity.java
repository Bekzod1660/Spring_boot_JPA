package com.example.spring_boot_jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phoneNumber;
//   @JsonIgnore
@JsonManagedReference
    @OneToMany(mappedBy = "userEntity")
    private List<LaptopEntity>laptopEntityList;

    public UserEntity(String name, String phoneNumber, List<LaptopEntity> laptopEntityList) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.laptopEntityList = laptopEntityList;
    }
}
