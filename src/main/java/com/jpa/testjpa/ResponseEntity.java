package com.jpa.testjpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class ResponseEntity {

    private String message;
    private HttpStatus status;
    private Object data;


    public ResponseEntity(String message) {
        this.message = message;
    }
    public ResponseEntity(String message,HttpStatus status) {
        this.message = message;
        this.status=status;
    }


}
