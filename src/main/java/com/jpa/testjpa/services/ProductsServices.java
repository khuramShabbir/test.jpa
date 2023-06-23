package com.jpa.testjpa.services;


import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dao.ProductRepo;
import com.jpa.testjpa.dao.UserRepo;
import com.jpa.testjpa.dto.ProductsDto;
import com.jpa.testjpa.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductsServices {
    @Autowired
    private ProductRepo repo;
    @Autowired

     UserRepo userRepo;

    public ResponseEntity createProducts(ProductsDto dto) {

        if (Objects.isNull(dto.getEmail())) {
            return new ResponseEntity("Pin name required");
        } else if (Objects.isNull(dto.getProductName())) {
            return new ResponseEntity("Product name required");
        }
        if (Objects.isNull(dto.getPrice())) {
            return new ResponseEntity("Price name required");
        }

        Optional<UserEntity> userEntity = userRepo.findByEmail(dto.getEmail());

        if (userEntity.isPresent()) {
            return new ResponseEntity("User Not Exist");
        }


        return new ResponseEntity("Products Added", repo.save(dto.convertToEntity()).convertToDto());
    }

    public ResponseEntity getProducts() {


        return new ResponseEntity("Products");

    }

    public ResponseEntity getAllProducts() {

        return new ResponseEntity("Products");

    }

    public ResponseEntity updateProducts() {
        return new ResponseEntity("Products Updated");
    }

    public ResponseEntity deleteProducts() {

        return new ResponseEntity("Products Deleted");

    }


}
