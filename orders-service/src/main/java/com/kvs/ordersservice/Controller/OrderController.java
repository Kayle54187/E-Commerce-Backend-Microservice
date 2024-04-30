package com.kvs.ordersservice.Controller;


import com.kvs.ordersservice.Dto.OrderRequestDTO;
import com.kvs.ordersservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place-order")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        orderService.placeOrder(orderRequestDTO);
    }
}
