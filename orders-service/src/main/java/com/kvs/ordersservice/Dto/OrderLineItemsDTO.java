package com.kvs.ordersservice.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderLineItemsDTO {

    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
