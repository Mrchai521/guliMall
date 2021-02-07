package com.cxf.gulimall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfchai
 * @ClassName OrderApplication.java
 * @Description 订单启动类
 * @createTime 2021/01/29 11:18:00
 */
//@MapperScan("com.cxf.gulimall.order")
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
