package com.yarm.api.controller;

import com.yarm.pojo.http.ResponseApi;
import com.yarm.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/30
 * Time:18:07
 * Des:
 */
@RestController
@RequestMapping("demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    /**
     * 执行写入
     * @return
     */
    public ResponseApi<String> exAnnotation(){
        ResponseApi<String> responseApi = new ResponseApi<>();
        this.demoService.insert();
        responseApi.setData("ok");
        return null;
    }
}