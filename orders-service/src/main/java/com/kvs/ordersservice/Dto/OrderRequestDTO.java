package com.kvs.ordersservice.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequestDTO {

    private List<OrderLineItemsDTO> orderLineItemsDTOList;
}
