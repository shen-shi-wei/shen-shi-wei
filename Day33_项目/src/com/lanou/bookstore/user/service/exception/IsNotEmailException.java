package com.lanou.bookstore.user.service.exception;

public class IsNotEmailException extends RegisterException {
    @Override
    public String getMessage() {
        return "请输入有效邮箱";
    }
}
