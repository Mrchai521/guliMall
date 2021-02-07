package com.cxf.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xfchai
 * @ClassName MemberApplication.java
 * @Description 会员启动类
 * @createTime 2021/01/29 11:11:00
 */
//@MapperScan("com.cxf.gulimall.member.dao")
@SpringBootApplication
@EnableFeignClients(basePackages = "com.cxf.gulimall.member.feign")
@EnableDiscoveryClient
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}
