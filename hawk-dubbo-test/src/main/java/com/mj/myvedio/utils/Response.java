package com.mj.myvedio.utils;

import java.io.Serializable;

/**
 * mj
 * @author mj
 * @param <T>
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T  data;
    private String msg;
    private Integer code;

    private Response(int code, String msg, T data){
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    private Response(ResponseStateEnum stateEnum, T data){
        this(stateEnum.getCode(), stateEnum.getMsg(), data);
    }

    public static Response createSuccess(){
        return new Response(ResponseStateEnum.SUCCESS, null);
    }

    public static Response createSuccess(Object data){
        return new Response(ResponseStateEnum.SUCCESS, data);
    }
    public static Response createSuccess(String msg,Object data){
        return new Response(ResponseStateEnum.SUCCESS.getCode(), msg, data);
    }
    public static Response createError(String msg){
        return new Response(ResponseStateEnum.ERROR.getCode(), msg, null);
    }

    public static Response createError(){
        return new Response(ResponseStateEnum.ERROR, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
