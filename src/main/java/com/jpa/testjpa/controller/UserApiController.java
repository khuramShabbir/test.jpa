package com.jpa.testjpa.controller;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.models.JwtResponse;
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
    public JwtResponse createOrGetUser(
            @RequestParam("name") String name,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("emailId") String emailId,
            @RequestParam("googleId") String googleId,
            @RequestParam("appleId") String appleId
//            @RequestParam("image") String image,
//            @RequestParam("file") MultipartFile file
    ) {
        System.out.println(name+emailId+googleId+appleId);
        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setEmailID(emailId);
        userDto.setPhoneNumber(phoneNumber);
        userDto.setGoogleID(googleId);
        userDto.setAppleID(appleId);
        return userServices.createOrGetUser(userDto);
    }

}
