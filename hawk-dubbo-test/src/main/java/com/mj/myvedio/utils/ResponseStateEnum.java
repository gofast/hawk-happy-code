package com.mj.myvedio.utils;

public enum ResponseStateEnum {

    SUCCESS(200,"成功"),
    ERROR(100, "失败")
    ;
    private int code;
    private String msg;
    private ResponseStateEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
