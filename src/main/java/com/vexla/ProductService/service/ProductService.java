package com.vexla.ProductService.service;

import com.vexla.ProductService.model.ProductRequest;
import com.vexla.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);
    ProductResponse getProductById(long productId);
}
