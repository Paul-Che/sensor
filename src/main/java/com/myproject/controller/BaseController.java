package com.myproject.controller;


import com.myproject.service.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.function.Supplier;

public class BaseController {
    protected <T> ResponseEntity<T> execute(Supplier<T> supplier){
        try{
            return new ResponseEntity<T>(supplier.get(), HttpStatus.OK);
        }catch(CommonException e){
            return new ResponseEntity(e.getMessage(), e.getHttpStatus());
        }
    }
}
