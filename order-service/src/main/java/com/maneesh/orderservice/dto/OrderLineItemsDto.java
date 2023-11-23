package com.maneesh.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItemsDto {

    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
