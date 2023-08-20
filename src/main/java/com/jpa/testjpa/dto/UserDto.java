package com.jpa.testjpa.dto;

import com.jpa.testjpa.models.UserEntity;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;

    private String phoneNumber;

    public UserEntity convertToEntity() {
        UserEntity entity = new UserEntity();
        entity.setPhoneNumber(this.phoneNumber);
        entity.setName(this.name);


        return entity;
    }

}
