package com.jpa.testjpa.models;

import com.jpa.testjpa.dto.UserDto;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "user")
public class UserEntity {
    @CreatedDate
    @LastModifiedDate
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usr_id")
    private int id;
    private String name;
    @Column(unique = true)
    private String phoneNumber;
    private String googleID;
    private String emailID;
    private String appleID;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<CarEntity> cars = new ArrayList<>();


    public UserDto convertToDto() {
        UserDto dto = new UserDto();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setPhoneNumber(this.phoneNumber);
        dto.setEmailID(this.emailID);
        dto.setGoogleID(this.googleID);
        dto.setAppleID(this.appleID);

        return dto;
    }

}
