package com.vexla.ProductService.service;

import com.vexla.ProductService.entity.Product;
import com.vexla.ProductService.exception.ProductServiceCustomException;
import com.vexla.ProductService.model.ProductRequest;
import com.vexla.ProductService.model.ProductResponse;
import com.vexla.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product...");

        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);
        log.info("Product created");

        return product.getProductId();
    }
    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Get the product for productId: {}", productId);
        //query Db
        Product product = productRepository.findById(productId)
                .orElseThrow(
                        () -> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
    log.info("Reduce Quantity {} for Id: {}",quantity, productId);

    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ProductServiceCustomException("" +
                    "Product with given Id not found",
                    "PRODUCT_NOT_FOUND"));

    if (product.getQuantity() < quantity) {
        throw new ProductServiceCustomException(
                "Product does not have sufficient Quantity",
                "INSUFFICIENT_QUANTITY");
        }
    product.setQuantity(product.getQuantity() - quantity);
    productRepository.save(product);
    log.info("Product Quantity updated Successfully");

    }
}
