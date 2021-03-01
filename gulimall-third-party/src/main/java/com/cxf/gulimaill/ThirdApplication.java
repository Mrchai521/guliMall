package com.cxf.gulimaill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfchai
 * @ClassName ThirdApplication.java
 * @Description 第三方服务启动类
 * @createTime 2021/03/01 16:39:00
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class ThirdApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThirdApplication.class);
    }
}
