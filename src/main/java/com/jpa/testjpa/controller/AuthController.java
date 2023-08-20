package com.jpa.testjpa.controller;

import com.jpa.testjpa.models.JwtRequest;
import com.jpa.testjpa.models.JwtResponse;
import com.jpa.testjpa.security.jwtAuthEntryPoint.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AuthController {
    @Autowired
    private UserDetailsService service;
    @Autowired
   private AuthenticationManager manager;
    @Autowired
  private   JWTHelper helper;


//    @PostMapping("/login")
//    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
//        this.doAuthenticate(request.getPhoneNumber());
//        UserDetails userDetails = service.loadUserByUsername(request.getPhoneNumber());
//        String token = this.helper.generateToken(userDetails);
//        JwtResponse response = JwtResponse.builder().mobileNumber(request.getPhoneNumber())
//                .token(token)
//                .build();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//    private void doAuthenticate(String phone) {
//
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(phone,"");
//        try {
//            manager.authenticate(authentication);
//
//
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException("Invalid Username");
//        }
//
//    }
//
//    @ExceptionHandler(BadCredentialsException.class)
//    public String exceptionHandler() {
//        return "Credentials Invalid !!";
//    }

}



