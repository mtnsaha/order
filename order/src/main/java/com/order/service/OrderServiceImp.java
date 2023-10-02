package com.order.service;

import com.order.common.Payment;
import com.order.common.TransactionRequest;
import com.order.common.TransactionResponse;
import com.order.entity.Order;
import com.order.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;
    private String response="";

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){
        Order order= transactionRequest.getOrder();
        Payment payment= transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

       Payment paymentResponse = restTemplate.postForObject("http://http://localhost:9002/payment/doPayment",payment,Payment.class);
        response= paymentResponse.getPaymentStatus().equals("success")?"payment processing successful order placed":"there is failed in order api, order added cart";
         orderRepository.save(order);
         return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }



}
