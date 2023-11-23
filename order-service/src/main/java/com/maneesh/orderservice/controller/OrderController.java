package com.maneesh.orderservice.controller;


import com.maneesh.orderservice.dto.OrderRequest;
import com.maneesh.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order has been placed";

    }

}
