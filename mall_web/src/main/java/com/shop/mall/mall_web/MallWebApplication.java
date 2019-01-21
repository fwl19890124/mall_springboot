package com.shop.mall.mall_web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@Slf4j
@SpringBootApplication
//@EnableEurekaServer
public class MallWebApplication {

    public static void main(String[] args) {
        log.info("======项目启动=====");
        SpringApplication.run(MallWebApplication.class, args);
    }
}
