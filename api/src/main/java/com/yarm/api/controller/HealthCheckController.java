package com.yarm.api.controller;

import com.yarm.pojo.http.ResponseApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/30
 * Time:16:36
 * Des:健康检测
 */
@RestController
public class HealthCheckController {

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseApi<Boolean> check(){
        ResponseApi<Boolean> responseApi = new ResponseApi();
        return responseApi;
    }
}