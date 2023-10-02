package com.order.service;

import com.order.common.TransactionRequest;
import com.order.common.TransactionResponse;
import com.order.entity.Order;

public interface OrderService {

    TransactionResponse saveOrder(TransactionRequest transactionRequest);
}
