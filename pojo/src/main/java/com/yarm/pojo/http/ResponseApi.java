package com.yarm.pojo.http;

import com.yarm.pojo.constant.ResponseCode;
import lombok.Data;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/30
 * Time:16:39
 * Des:
 */
@Data
public class ResponseApi<T> {
    // 返回参数
    private T data;
    // 返回状态
    private boolean status;
    // 返回错误信息
    private String errorMsg;
    // 返回状态码
    private int code;

    // 默认请求返回
    public ResponseApi(){
        this.status = true;
        this.code = ResponseCode.OK.getValue();
        this.errorMsg = ResponseCode.OK.getMsg();
    }
}