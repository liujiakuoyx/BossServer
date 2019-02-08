package com.liujiakuo.boss.base.http;

public class DataResponse<T> extends MessageResponse{
    private T data;

    public DataResponse(int code, String message) {
        super(code, message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
