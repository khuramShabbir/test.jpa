package com.jpa.testjpa.models;

import com.jpa.testjpa.dto.CarDto;
import com.jpa.testjpa.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cars")

public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private int id;
    private String carName;
    private String model;
    @ManyToOne
    @JoinColumn(name = "id") // The foreign key column in Car table
    private UserEntity user;

    public CarDto convertToDto() {
        CarDto dto = new CarDto();
        dto.setCarName(this.carName);
        dto.setModel(this.model);
        dto.setUser(this.user);
        return dto;
    }

}
