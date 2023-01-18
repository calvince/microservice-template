package com.vexla.ProductService.controller;

import com.vexla.ProductService.model.ProductRequest;
import com.vexla.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //add product
    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long productId = productService.addProduct(productRequest);

        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    //get product by id
}
