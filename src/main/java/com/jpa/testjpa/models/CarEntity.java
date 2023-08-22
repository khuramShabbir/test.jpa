package com.jpa.testjpa.models;

import com.jpa.testjpa.dto.CarDto;
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
//    @Column(name = "car_id")
    private int id;
    private int addedByUserId;
    private String madeBy;
    private String model;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public CarDto convertToDto() {
        CarDto dto = new CarDto();
        dto.setCarName(this.madeBy);
        dto.setModel(this.model);
        dto.setAddedBuUserId(this.addedByUserId);
        dto.setUser(this.user);
        return dto;
    }

    public CarEntity saveCar(CarEntity entity){
        CarEntity carEntity=new CarEntity();
        carEntity.setMadeBy(entity.getMadeBy());
        carEntity.setModel(entity.getModel());
        carEntity.setUser(entity.getUser());
        return carEntity;
    }

}
