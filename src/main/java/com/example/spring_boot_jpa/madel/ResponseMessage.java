package com.example.spring_boot_jpa.madel;

public enum ResponseMessage {
    SUCCESS("transaction is success",0),
    ERROR_PRODUCT_NOT_FOUND("product not found", -100),
    ERROR_USER_NOT_FOUND("user not found", -200),
    ERROR_USER_ALREADY_EXIST("user already exist", -201);

        private String massage;
        private int statusCode;

    public String getMassage() {
        return massage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    ResponseMessage(String massage, int statusCode) {
        this.massage=massage;
        this.statusCode=statusCode;
    }
}
