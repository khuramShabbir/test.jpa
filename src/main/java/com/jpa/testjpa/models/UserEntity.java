package com.jpa.testjpa.models;

import com.jpa.testjpa.dto.UserDto;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "user")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usr_id")
    private int id;
    private String name;
    @Column(unique = true)
    private String phoneNumber;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<CarEntity> cars = new ArrayList<>();


    public UserDto convertToDto() {
        UserDto dto = new UserDto();
        dto.setName(this.name);
        dto.setPhoneNumber(this.phoneNumber);
        return dto;
    }

}
