package com.yarm.pojo.constant;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/30
 * Time:16:49
 * Des:
 */
public enum ResponseCode {
    OK(200,"ok"),
    BadRequest(4001,"request parameter error"),
    FAIL(5001, "request fail");

    private int value;
    private String msg;

    ResponseCode(int value, String msg){
        this.value = value;
        this.msg = msg;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}