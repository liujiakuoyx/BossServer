package com.liujiakuo.boss.base.http;


public class PageDataResponse<T> extends DataResponse<T> {
    private int page;//当前页

    public PageDataResponse(int code, String message) {
        super(code, message);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
