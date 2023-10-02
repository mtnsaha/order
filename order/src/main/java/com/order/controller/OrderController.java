package com.order.controller;

import com.order.common.Payment;
import com.order.common.TransactionRequest;
import com.order.common.TransactionResponse;
import com.order.entity.Order;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
OrderService orderService;

    @PostMapping("/placeOrder")
public TransactionResponse saveOrder(@RequestBody TransactionRequest  transactionRequest){


    return orderService.saveOrder(transactionRequest);
}







}
