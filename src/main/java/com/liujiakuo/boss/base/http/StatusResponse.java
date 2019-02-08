package com.liujiakuo.boss.base.http;

public class StatusResponse {
    protected int code;

    public StatusResponse(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
