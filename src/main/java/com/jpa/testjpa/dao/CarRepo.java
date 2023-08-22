package com.jpa.testjpa.dao;

import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.models.CarEntity;
import com.jpa.testjpa.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


import java.util.Optional;


@Repository

public interface CarRepo extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findByUserId(int id);
//    List<CarEntity> findByUserMobileNumber(String mobileNumber);




}
