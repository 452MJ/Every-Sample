package com.example.administrator.every_sample.bean;

/**
 * Created by Administrator on 2016/8/23.
 */
public class BaseBean<T> {


    /**
     * resultCode : 0
     * resultMessage : 成功
     * data : {}
     */

    private int resultCode;
    private String resultMessage;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
