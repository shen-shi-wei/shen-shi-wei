package com.lanou.bookstore.user.service.exception;

public class NotActiveException extends LoginException {
    @Override
    public String getMessage() {
        return "该账户未激活";
    }
}
