package com.lanou.bookstore.user.service.exception;

public class InvalidUsernameException extends LoginException {
    @Override
    public String getMessage() {
        return "该用户不存在";
    }
}
