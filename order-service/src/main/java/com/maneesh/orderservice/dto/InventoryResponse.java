package com.maneesh.orderservice.dto;


import lombok.*;

@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;
}
