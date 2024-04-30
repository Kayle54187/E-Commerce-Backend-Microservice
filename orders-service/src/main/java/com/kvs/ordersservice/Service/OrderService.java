package com.kvs.ordersservice.Service;


import com.kvs.ordersservice.Dto.OrderLineItemsDTO;
import com.kvs.ordersservice.Dto.OrderRequestDTO;
import com.kvs.ordersservice.Model.Order;
import com.kvs.ordersservice.Model.OrderLineItems;
import com.kvs.ordersservice.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        List<OrderLineItems> orderLineItemsList = orderRequestDTO.getOrderLineItemsDTOList().stream().map(this::mapToOrderLineItems).toList();

        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItems(orderLineItemsList);

        orderRepository.save(order);

        log.info("Order with order number {} placed successfully",order.getOrderNumber());
    }

    private OrderLineItems mapToOrderLineItems(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        return orderLineItems;
    }
}
