package com.jpa.testjpa.services;

import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dao.CarRepo;
import com.jpa.testjpa.dao.UserRepo;
import com.jpa.testjpa.dto.CarDto;
import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.models.CarEntity;
import com.jpa.testjpa.models.UserEntity;
import jakarta.validation.OverridesAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.List;

@Service
public class CarServices {
    private final CarRepo repo;
    private final UserRepo userRepo;

    @Autowired
    public CarServices(CarRepo repo, UserRepo userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public ResponseEntity createCar(CarEntity carEntity) {

        if (Objects.isNull(carEntity.getMadeBy()))
            return new ResponseEntity("Name And Model Required", HttpStatus.BAD_REQUEST, null);

        else if (carEntity.getMadeBy().isEmpty())
            return new ResponseEntity("Name Required", HttpStatus.BAD_REQUEST, null);
        else if (carEntity.getModel().isEmpty())
            return new ResponseEntity("Model Required", HttpStatus.BAD_REQUEST, null);

        Optional<UserEntity> byId = userRepo.findById(carEntity.getAddedByUserId());

        if (byId.isEmpty()) return new ResponseEntity("No User Found");

//        carEntity.setUser(byId.get());

        return new ResponseEntity("Car Created", HttpStatus.CREATED, repo.save(carEntity));
    }


    public ResponseEntity getCarById(CarDto carDto, UserDto userDto) {

        if (Objects.isNull(userDto)) return new ResponseEntity("User Id Required", HttpStatus.BAD_REQUEST);
        if (Objects.isNull(carDto)) return new ResponseEntity("Car Id Required", HttpStatus.BAD_REQUEST);
        carDto.setUser(userDto.convertToEntity());

        Optional<CarEntity> carEntity = repo.findById(carDto.getId());

        return carEntity.map(entity -> new ResponseEntity("Car Found", HttpStatus.FOUND, entity.convertToDto())).orElseGet(() -> new ResponseEntity("No Car Found", HttpStatus.NOT_FOUND));
    }

    public ResponseEntity getCarByUSer(int userID) {
        if (Objects.isNull(userID)) return new ResponseEntity("User Id Required", HttpStatus.BAD_REQUEST);

        List<CarEntity> carEntities = repo.findByUserId(userID);
        List<CarEntity> carsList= carEntities;

        System.out.println(carsList);
        if (carEntities.isEmpty()) return new ResponseEntity("No Cars Found", HttpStatus.NOT_FOUND,carsList);

        return new ResponseEntity("Cars Found", HttpStatus.FOUND,carsList);
    }


}
