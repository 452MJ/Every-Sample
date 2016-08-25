package com.example.administrator.every_sample.bean;

/**
 * Created by Administrator on 2016/8/23.
 */
public class BaseBean<T> {


    /**
     * code : 0
     * msg : 成功
     * data : {}
     */

    private int code;
    private String msg;
    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
