package com.jpa.testjpa.services;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dao.UserRepo;
import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.models.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;


@Service
@Transactional

public class UserServices {

    private final UserRepo repo;

    @Autowired
    public UserServices(UserRepo repo) {
        this.repo = repo;
    }
    public ResponseEntity createOrGetUser(UserDto dto) {
        if (Objects.isNull(dto) || dto.getPhoneNumber().isEmpty()) {
            return new ResponseEntity("Phone Number Required");
        }
        Optional<UserEntity> user = repo.findByPhoneNumber(dto.getPhoneNumber());
        System.out.println(user);
        return user.map(userEntity -> new ResponseEntity("User Found", HttpStatus.FOUND, userEntity.convertToDto().convertToEntity())).orElseGet(() -> new ResponseEntity("User Created", HttpStatus.CREATED, repo.save(dto.convertToEntity())));

    }


}
