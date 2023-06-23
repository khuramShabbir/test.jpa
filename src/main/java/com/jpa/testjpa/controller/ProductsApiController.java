package com.jpa.testjpa.controller;
import com.jpa.testjpa.ResponseEntity;
import com.jpa.testjpa.dto.ProductsDto;
import com.jpa.testjpa.services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController("/product")
public class ProductsApiController {

    @Autowired
    private ProductsServices services;

    @PostMapping(value = "/")
    @ResponseBody
    public ResponseEntity createProducts(@RequestBody ProductsDto dto) {
        return services.createProducts(dto);
    }

    @GetMapping(value = "/")
    public ResponseEntity getProducts(@Param("") ProductsDto dto) {
        return services.getProducts();
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAllProducts() {
        return services.getAllProducts();
    }
    @PutMapping(value = "/")
    public ResponseEntity updateProducts(ProductsDto dto) {
        return services.updateProducts();
    }
    @DeleteMapping(value = "/")
    public ResponseEntity deleteProducts(ProductsDto dto) {
        return services.deleteProducts();
    }
}
