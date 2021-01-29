package com.cxf.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xfchai
 * @ClassName CouponApplication.java
 * @Description 优惠券启动类
 * @createTime 2021/01/29 11:14:00
 */
@MapperScan("com.cxf.gulimall.coupon")
@SpringBootApplication
public class CouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class, args);
    }
}
