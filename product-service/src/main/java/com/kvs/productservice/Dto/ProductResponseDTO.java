package com.kvs.productservice.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
