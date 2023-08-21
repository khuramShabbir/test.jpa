package com.jpa.testjpa.controller;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController()
public class UserApiController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to share faire";
    }


    @PostMapping("/auth")
    @ResponseBody
    public ResponseEntity createOrGetUser(@RequestBody UserDto dto) {
        return userServices.createOrGetUser(dto);
    }

}
