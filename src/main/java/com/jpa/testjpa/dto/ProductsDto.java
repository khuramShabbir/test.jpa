package com.jpa.testjpa.dto;

import com.jpa.testjpa.models.ProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto {

    private String productName, email, price;

    public ProductsEntity convertToEntity() {
        ProductsEntity entity = new ProductsEntity();
        entity.setProductName(this.productName);
        entity.setPrice(this.price);

        return entity;
    }

}
