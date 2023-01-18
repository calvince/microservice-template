package com.vexla.ProductService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TBL_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(generator = "tbl_product")
    @SequenceGenerator(name = "tbl_product",sequenceName = "TBL_PRODUCT_SEQ",allocationSize = 1)
    private long productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRICE")
    private long price;
    @Column(name = "QUANTITY")
    private long quantity;
}
