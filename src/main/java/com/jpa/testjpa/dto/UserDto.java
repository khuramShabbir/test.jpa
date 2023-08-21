package com.jpa.testjpa.dto;

import com.jpa.testjpa.models.UserEntity;
import jakarta.persistence.Column;
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
    private int id;
    private String name;
    private String phoneNumber;
    private String googleID;
    private String emailID;
    private String appleID;
    public UserEntity convertToEntity() {
        UserEntity entity = new UserEntity();
        entity.setName(this.name);
        entity.setPhoneNumber(this.phoneNumber);
        entity.setEmailID(this.emailID);
        entity.setGoogleID(this.googleID);
        entity.setAppleID(this.appleID);
        return entity;
    }

}
