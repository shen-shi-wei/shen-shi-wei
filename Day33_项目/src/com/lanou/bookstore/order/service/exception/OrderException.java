package com.lanou.bookstore.order.service.exception;

public class OrderException extends Exception{
    @Override
    public String getMessage() {
        return "订单确认失败，你不是好人！";
    }
}
