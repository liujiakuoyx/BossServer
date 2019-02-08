package com.liujiakuo.boss.base.http;

public class MessageResponse extends StatusResponse {
    protected String message;

    public MessageResponse(int code, String message) {
        super(code);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
