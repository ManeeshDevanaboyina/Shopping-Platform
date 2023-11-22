package com.programmingtechie.orderservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="t_order_line_items")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;


}
