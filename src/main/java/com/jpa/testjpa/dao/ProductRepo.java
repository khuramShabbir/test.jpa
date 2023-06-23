package com.jpa.testjpa.dao;


import com.jpa.testjpa.models.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository <ProductsEntity,Integer>{





}
