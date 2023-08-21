package com.jpa.testjpa.dto;

import com.jpa.testjpa.models.CarEntity;
import com.jpa.testjpa.models.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private int id;
    private int addedBuUserId;
    private String madeBy;
    private String model;

    private UserEntity user;
    public CarEntity convertToEntity() {
        CarEntity entity = new CarEntity();
        entity.setMadeBy(this.madeBy);
        entity.setModel(this.model);
        entity.setUser(this.user);
        entity.setAddedByUserId(this.addedBuUserId);
        return entity;
    }


}
