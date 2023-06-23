package com.jpa.testjpa.controller;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
// TODO; ASK TO BUTT BADAR
@RestController
public class UserApiController {
    @Autowired
    private UserServices userServices;


    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDto dto) {
        return userServices.createUser(dto);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity getUser(@Param("") UserDto dto) {
        return userServices.getUser(dto);
    }

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public ResponseEntity getAllUser() {

        return userServices.getAllUser();
    }

    @PutMapping
    public ResponseEntity updatePassword(@RequestBody UserDto dto) {
        return userServices.changePassword(dto);
    }


    @DeleteMapping
    @ResponseBody
    public ResponseEntity deleteUser(UserDto dto) {
        return userServices.deleteUser(dto);
    }
}
