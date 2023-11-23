package com.maneesh.productservice.controller;


import com.maneesh.productservice.dto.ProductRequest;
import com.maneesh.productservice.dto.ProductResponse;
import com.maneesh.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/product")
public class ProductController {


    private ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //ProductRequest acts as a DTO
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductResponse> getAllProducts(){

        return productService.getAllProducts();
    }


}
