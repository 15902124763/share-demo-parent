package com.yarm.service.demo;

import com.yarm.pojo.http.ResponseApi;
import com.yarm.service.annotation.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/30
 * Time:18:04
 * Des:
 */
@Service
@Slf4j
public class DemoService {

    @MyAnnotation(name = "注解拦截")
    public ResponseApi<String> insert(Long id){
        this.getData();
        // 写入
        log.info("------注解拦截执行写入完成------");

        // 返回
        return new ResponseApi<>();
    }


    public ResponseApi<String> update(String name){
        this.getData();
        // 执行update
        log.info("------方法拦截执行update完成------");

        // 返回
        return new ResponseApi<>();
    }

    // 写入前拼接数据
    private void getData() {
        log.info("------执行业务逻辑------");
    }
}