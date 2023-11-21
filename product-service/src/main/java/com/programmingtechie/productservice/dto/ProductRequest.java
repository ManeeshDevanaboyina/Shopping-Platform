package com.programmingtechie.productservice.dto;

import com.programmingtechie.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequest {

    private String name;
    private String description;
    private BigDecimal price;

}
