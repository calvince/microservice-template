package com.vexla.ProductService.exception;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ProductServiceCustomException extends RuntimeException {

    private String errorCode;
    private Date date;
    public ProductServiceCustomException(String message,String errorCode) {
        super(message);
        this.errorCode = errorCode;
        theDate();
    }
    public String theDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }


}
