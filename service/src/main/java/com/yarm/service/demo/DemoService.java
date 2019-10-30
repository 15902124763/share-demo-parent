package com.yarm.service.demo;

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
    public void insert(){
        // 写入
        System.out.println("------执行写入------");
    }
}