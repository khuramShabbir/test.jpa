package com.jpa.testjpa.services;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dao.CarRepo;
import com.jpa.testjpa.dto.CarDto;
import com.jpa.testjpa.models.CarEntity;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CarServices {
    private final CarRepo repo;

    @Autowired
    public CarServices(CarRepo repo) {
        this.repo = repo;
    }

    public ResponseEntity createCar(CarEntity entity) {

        return new ResponseEntity("Car Created", HttpStatus.CREATED, repo.save(entity));
    }


    public ResponseEntity getCarById(CarDto dto) {
        if (Objects.isNull(dto)) return new ResponseEntity("Car Id Required", HttpStatus.BAD_REQUEST);

        Optional<CarEntity> carEntity = repo.findById(dto.getId());

        return carEntity.map(entity -> new ResponseEntity("Car Found", HttpStatus.FOUND, entity.convertToDto())).orElseGet(() -> new ResponseEntity("No Car Found", HttpStatus.NOT_FOUND));
    }
}
