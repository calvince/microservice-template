package com.vexla.ProductService.controller;

import com.vexla.ProductService.model.ProductRequest;
import com.vexla.ProductService.model.ProductResponse;
import com.vexla.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {
         ProductResponse productResponse =
                 productService.getProductById(productId);

         return new ResponseEntity<>(productResponse,HttpStatus.OK);

    }
}
