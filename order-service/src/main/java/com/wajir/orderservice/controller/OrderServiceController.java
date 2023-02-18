package com.wajir.orderservice.controller;

import com.wajir.orderservice.dto.OrderRequest;
import com.wajir.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderServiceController
{

    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest ){
        orderService.placeOrder(orderRequest);
        return "Order placed successfully.";
    }

}
