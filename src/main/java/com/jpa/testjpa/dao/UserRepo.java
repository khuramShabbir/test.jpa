package com.jpa.testjpa.dao;
import com.jpa.testjpa.dto.UserDto;
import com.jpa.testjpa.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
     Optional<UserEntity> findByPhoneNumber(String number);


}
