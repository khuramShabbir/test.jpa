package com.jpa.testjpa.controller;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dto.CarDto;
import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.models.CarEntity;
import com.jpa.testjpa.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController()
public class CarController {

    @Autowired
    private CarServices services;

    @PostMapping("/addCar")
    @ResponseBody

    public ResponseEntity createCar(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "user_id", required = false) String addedByUserId,
            @RequestParam("madeBy") String madeBy,
            @RequestParam("model") String model,

            CarEntity carEntity) {

        return services.createCar(carEntity);

    }

    @PostMapping("/getCar")
    @ResponseBody
    public ResponseEntity getCarByID(@RequestBody CarDto carDto, UserDto userDto) {
        return services.getCarById(carDto, userDto);
    }

    @PostMapping("/getAllCars")
    @ResponseBody
    public ResponseEntity getAllCarsByUser(

            @RequestParam(value = "user_id") int userId,
            int user_id
    ) {

        return services.getCarByUSer(userId);
    }


}
