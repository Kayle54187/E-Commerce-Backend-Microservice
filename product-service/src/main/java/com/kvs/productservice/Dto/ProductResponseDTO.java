package com.kvs.productservice.Dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ProductResponseDTO {
    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private BigDecimal price;
}
