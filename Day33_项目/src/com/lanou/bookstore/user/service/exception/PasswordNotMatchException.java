package com.lanou.bookstore.user.service.exception;

public class PasswordNotMatchException extends LoginException {
    @Override
    public String getMessage() {
        return "密码不匹配";
    }
}
