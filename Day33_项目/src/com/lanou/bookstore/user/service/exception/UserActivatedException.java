package com.lanou.bookstore.user.service.exception;

public class UserActivatedException extends RegisterException {
    @Override
    public String getMessage() {
        return "该用户已被激活";
    }
}
