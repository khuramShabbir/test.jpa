package com.jpa.testjpa.dto;

import com.jpa.testjpa.models.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private  String name, email, password,oldPassword, newPassword;


    public UserEntity convertToEntity(){
        UserEntity entity = new UserEntity();
        entity.setName(this.name);
        entity.setPassword(this.password);
        entity.setEmail(this.email);

        return entity;
    }

}
