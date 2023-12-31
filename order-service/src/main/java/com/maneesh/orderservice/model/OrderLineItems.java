package com.maneesh.orderservice.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="t_order_line_items")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
