package com.lanou.bookstore.user.service.exception;

public class EmailExitException extends RegisterException {
    @Override
    public String getMessage() {
        return "该邮箱已注册";
    }
}
