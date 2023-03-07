package com.example.spring_boot_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "laptop")
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String madel;
    @JsonBackReference
    @ManyToOne
//    @JsonIgnore
    private UserEntity userEntity;

    public LaptopEntity(String madel, UserEntity userEntity) {
        this.madel = madel;
        this.userEntity = userEntity;
    }
}
