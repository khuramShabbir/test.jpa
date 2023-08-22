package com.jpa.testjpa.services;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dao.CarRepo;
import com.jpa.testjpa.dao.UserRepo;
import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.models.CarEntity;
import com.jpa.testjpa.models.JwtResponse;
import com.jpa.testjpa.models.UserEntity;
import com.jpa.testjpa.security.jwtAuthEntryPoint.JWTHelper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.List;


@Service
@Transactional

public class UserServices {

    private final UserRepo repo;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager manager;
    private final JWTHelper helper;
    private final CarRepo carRepo;


    @Autowired
    public UserServices(UserRepo repo, UserDetailsService userDetailsService, AuthenticationManager manager, JWTHelper helper,
                        CarRepo carRepo) {
        this.repo = repo;
        this.userDetailsService = userDetailsService;
        this.manager = manager;
        this.helper = helper;
        this.carRepo = carRepo;
    }


    public JwtResponse createOrGetUser(UserDto dto) {
        if (Objects.isNull(dto) || dto.getPhoneNumber().isEmpty()) {
            return new JwtResponse("Phone Number Required", HttpStatus.BAD_REQUEST.value(), null, null);
        }
        JWTHelper jwtHelper = new JWTHelper();
        Optional<UserEntity> user = repo.findByPhoneNumber(dto.getPhoneNumber());
        if (user.isEmpty()) {
            UserEntity userEntity = repo.save(dto.convertToEntity());
            return new JwtResponse("User Created", HttpStatus.CREATED.value(), jwtHelper.generateToken(dto.getPhoneNumber()), userEntity);
        } else {
//            List<CarEntity> carEntity = carRepo.findByUserMobileNumber(dto.getPhoneNumber());
//
//            System.out.println(carEntity);



            return new JwtResponse("User Found", HttpStatus.FOUND.value(),
                    jwtHelper.generateToken(dto.getPhoneNumber()),
                    user.get().convertToDto().convertToEntity());
        }
    }
}