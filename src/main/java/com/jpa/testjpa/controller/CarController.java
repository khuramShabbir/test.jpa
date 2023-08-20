package com.jpa.testjpa.controller;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dto.CarDto;
import com.jpa.testjpa.models.CarEntity;
import com.jpa.testjpa.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController()
public class CarController {

    @Autowired
    private CarServices services;

    @PostMapping("/addCar")
    @ResponseBody

    public ResponseEntity createCar(@RequestBody CarDto dto) {

        if (Objects.isNull(dto)) return new ResponseEntity("Name And Model Required", HttpStatus.BAD_REQUEST, null);
        else if (dto.getCarName().isEmpty()) return new ResponseEntity("Name Required", HttpStatus.BAD_REQUEST, null);
        else if (dto.getModel().isEmpty()) return new ResponseEntity("Model Required", HttpStatus.BAD_REQUEST, null);

        return services.createCar(dto.convertToEntity());

    }

    @PostMapping("/getCar")
    @ResponseBody
    public ResponseEntity getCarByID(@RequestBody CarDto dto) {
        return services.getCarById(dto);
    }


}
