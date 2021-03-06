package com.cxf.gulimall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfchai
 * @ClassName WareApplication.java
 * @Description TODO
 * @createTime 2021/01/29 11:33:00
 */
@SpringBootApplication
//@MapperScan("com.cxf.gulimall.dao")
@EnableDiscoveryClient
public class WareApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareApplication.class, args);
    }
}
