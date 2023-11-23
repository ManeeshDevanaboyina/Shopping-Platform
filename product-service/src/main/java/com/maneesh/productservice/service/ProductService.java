package com.maneesh.productservice.service;

import com.maneesh.productservice.model.Product;
import com.maneesh.productservice.dto.ProductRequest;
import com.maneesh.productservice.dto.ProductResponse;
import com.maneesh.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    //All args constructor will takecare of Injection

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        //Map the ProductRequest with the Product Model

        Product product=Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();

        productRepository.save(product);
        log.info("Product "+product.getId() +" is Saved.");

    }

    public List<ProductResponse> getAllProducts(){
        //Map the ProductRequest with the Product Model

        List<Product> products=productRepository.findAll();

        //List<ProductResponse> product=products.stream().map(product1 -> new ProductResponse()).toList();


         return  products.stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();

    }


}
