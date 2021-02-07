package com.cxf.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xfchai
 * @ClassName CouponApplication.java
 * @Description 优惠券启动类
 * @createTime 2021/01/29 11:14:00
 */

@SpringBootApplication

public class CouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class, args);
    }
}
