package com.jpa.testjpa.services;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dao.UserRepo;
import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.models.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
@Transactional

public class UserServices {

    @Autowired
    private UserRepo repo;

    // TODO: Ask for @NotNull Annotation
    public ResponseEntity createUser(UserDto dto) {

        if (Objects.isNull(dto.getName())) {
            return new ResponseEntity("Name Required");
        } else if (dto.getEmail() == null) {
            return new ResponseEntity("Email Required");
        } else if (dto.getPassword() == null) {
            return new ResponseEntity("Password Required");
        } else if (repo.existsByEmail(dto.getEmail())) {
            System.out.println(dto.getEmail());
            return new ResponseEntity("User Already Exist");
        }

        return new ResponseEntity("User Created", repo.save(dto.convertToEntity()).convertToDto());
    }

    public ResponseEntity getUser(UserDto dto) {

        if (Objects.isNull(dto.getEmail())) {
            return new ResponseEntity("Email Required");
        }
        Optional<UserEntity> user = repo.findByEmail(dto.getEmail());
        if (user.isEmpty()) {
            return new ResponseEntity("User Not Exist");
        } else {
            if (dto.getPassword() == null) {
                return new ResponseEntity("Password Required");
            } else if (!dto.getPassword().equals(user.get().getPassword())) {
                return new ResponseEntity("Wrong Password");
            }
        }
        return new ResponseEntity("Login Successfully", user.get().convertToDto());

    }

    public ResponseEntity getAllUser() {

        return new ResponseEntity("Success", repo.findAll());

    }

    public ResponseEntity changePassword(UserDto dto) {

        Optional<UserEntity> user = repo.findByEmail(dto.getEmail());


        if (Objects.isNull(dto.getEmail())) {
            return new ResponseEntity("Email Required");
        } else if (Objects.isNull(dto.getPassword())) {

            return new ResponseEntity("Password Required");


        } else if (user.isEmpty()) {

            return new ResponseEntity("User Not Exist");
        }

        if (!Objects.equals(user.get().getPassword(), dto.getOldPassword())) {
            return new ResponseEntity("Wrong Password");
        }
        user.get().setPassword(dto.getNewPassword());
        return new ResponseEntity("Password Updated", repo.save(user.get()).convertToDto());
    }

    public ResponseEntity deleteUser(UserDto dto) {
        Optional<UserEntity> user = repo.findByEmail(dto.getEmail());

        if (Objects.isNull(dto.getEmail())) {

            return new ResponseEntity("Email Required");


        } else if (Objects.isNull(dto.getPassword())) {

            return new ResponseEntity("Password Required");


        } else if (user.isEmpty()) {

            return new ResponseEntity("User Not Exist");
        }
        if (!Objects.equals(user.get().getPassword(), dto.getPassword())) {
            return new ResponseEntity("Wrong Password");
        }

        repo.deleteUserByEmail(dto.getEmail());
        return new ResponseEntity("User Deleted");

    }


}
