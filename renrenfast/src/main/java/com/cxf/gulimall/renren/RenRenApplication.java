package com.cxf.gulimall.renren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfchai
 * @ClassName RenRenApplication.java
 * @Description 人人快速开发平台启动类
 * @createTime 2021/02/20 11:30:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RenRenApplication {
    public static void main(String[] args) {
        SpringApplication.run(RenRenApplication.class);
    }
}
