package com.jpa.testjpa.models;


import com.jpa.testjpa.dto.ProductsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsEntity {




    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(unique = true)
    private int id;

    private String productName;
    private String price;
//    private int createdBy;

//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false)
//     private   UserEntity user;
    public ProductsDto convertToDto() {
        ProductsDto dto = new ProductsDto();
        dto.setProductName(this.productName);
        dto.setPrice(this.price);



        return dto;
    }


}
