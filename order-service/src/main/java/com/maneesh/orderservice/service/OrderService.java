package com.maneesh.orderservice.service;

import com.maneesh.orderservice.repository.OrderRepository;
import com.maneesh.orderservice.dto.OrderLineItemsDto;
import com.maneesh.orderservice.dto.OrderRequest;
import com.maneesh.orderservice.model.Order;
import com.maneesh.orderservice.model.OrderLineItems;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){

        Order order= Order.builder().
                orderNumber(UUID.randomUUID().toString()).
                orderLineItemsList(orderRequest
                        .getOrderLineItemsDtoList()
                        .stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto))
                        .toList()).build();

        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {

        return OrderLineItems.builder()
                .price(orderLineItemsDto.getPrice())
                .skuCode(orderLineItemsDto.getSkuCode())
                .quantity(orderLineItemsDto.getQuantity())
                .build();
    }
}
