package com.example.administrator.every_sample.bean;

/**
 * Created by Administrator on 2016/8/23.
 */
public class BaseBean<T> {


    /**
     * start : 0
     * msg : 成功
     * data : {}
     */

    private int start;
    private String msg;
    private String request;
    private T data;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
