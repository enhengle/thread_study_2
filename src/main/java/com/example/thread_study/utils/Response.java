package com.example.thread_study.utils;

/**
 * @author lingwang
 * @date 2021/12/9 11:20
 */
public class Response<T> {

    private int code;//返回编码
    private String msg;//返回信息
    private T data;//返回信息

    public Response(){}

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(T data) {
        this.data = data;
    }

    public static <T> Response<T> ok(T data) {
        return new Response<>(data);
    }

    public static Response error(int code ,String msg) {
        return new Response(code,msg);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
