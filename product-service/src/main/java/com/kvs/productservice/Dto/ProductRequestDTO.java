package com.kvs.productservice.Dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    @Min(value = 0, message = "Price must be greater than 0")
    private BigDecimal price;
}
