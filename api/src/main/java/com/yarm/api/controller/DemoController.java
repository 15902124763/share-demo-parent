package com.yarm.api.controller;

import com.yarm.pojo.http.ResponseApi;
import com.yarm.service.demo.DemoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Slf4j
public class DemoController {
    @Autowired
    private DemoService demoService;

    /**
     * 执行写入
     * @return
     */
    @GetMapping("add")
    @ApiOperation(value = "注解方式", notes = "Aop Demo")
    public ResponseApi<String> exAnnotation(){
        ResponseApi<String> responseApi = new ResponseApi<>();

        log.info("------注解拦截调用方法前------");
        this.demoService.insert(110L);
        log.info("------注解拦截调用方法后------");

        responseApi.setData("ok");
        return responseApi;
    }

    /**
     * 执行update
     * @return
     */
    @GetMapping("update")
    @ApiOperation(value = "非注解方式", notes = "Aop Demo")
    public ResponseApi<String> update(){
        ResponseApi<String> responseApi = new ResponseApi<>();

        log.info("------非注解拦截调用方法前------");
        this.demoService.update("燕人张飞");
        log.info("------非注解拦截调用方法后------");

        responseApi.setData("ok");
        return responseApi;
    }
}