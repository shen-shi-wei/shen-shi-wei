package com.lanou.bookstore.user.service.exception;

public class UserExitException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户已存在";
    }
}
