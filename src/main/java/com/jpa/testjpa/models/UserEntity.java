package com.jpa.testjpa.models;

import com.jpa.testjpa.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String token;

    public UserDto convertToDto() {
        UserDto dto = new UserDto();
        dto.setName(this.name);
        dto.setEmail(this.email);
        return dto;
    }


    public UserEntity(int id, String name, String password, String email) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;


    }

    public UserEntity() {

        super();
        // TODO: Auto generated constructor


    }

    public UserEntity(String name, String email, String password) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
