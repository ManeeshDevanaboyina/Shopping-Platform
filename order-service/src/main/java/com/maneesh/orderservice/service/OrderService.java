package com.maneesh.orderservice.service;

import com.maneesh.orderservice.dto.InventoryResponse;
import com.maneesh.orderservice.repository.OrderRepository;
import com.maneesh.orderservice.dto.OrderLineItemsDto;
import com.maneesh.orderservice.dto.OrderRequest;
import com.maneesh.orderservice.model.Order;
import com.maneesh.orderservice.model.OrderLineItems;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional //Spring framework will automatically create and commit the transactions
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest){

        Order order= Order.builder().
                orderNumber(UUID.randomUUID().toString()).
                orderLineItemsList(orderRequest
                        .getOrderLineItemsDtoList()
                        .stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto))
                        .toList()).build();

       List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(orderLineItems -> orderLineItems.getSkuCode()).toList();

        //Call Inventory Service to find whether the product is in stock
        System.out.println("skuCodes received from User"+skuCodes);

       InventoryResponse[] inventoryResponseArray= webClient.get()
                .uri("http://localhost:8082/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)//reading data from web client response
                .block();//Webclient makes Synchronous request to Inventory Endpoint

        System.out.println("inventoryResponseArray"+Arrays.toString(inventoryResponseArray));

        boolean allProductsInStock=Arrays.stream(inventoryResponseArray).allMatch(inventoryResponse -> inventoryResponse.isInStock());

        System.out.println("allProductsInStock"+allProductsInStock);

        if(allProductsInStock){
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Product is not in Stock, Try again after some time");
        }



    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {

        return OrderLineItems.builder()
                .price(orderLineItemsDto.getPrice())
                .skuCode(orderLineItemsDto.getSkuCode())
                .quantity(orderLineItemsDto.getQuantity())
                .build();
    }
}
