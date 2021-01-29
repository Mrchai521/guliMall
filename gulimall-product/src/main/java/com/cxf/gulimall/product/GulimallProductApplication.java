package com.cxf.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xfchai
 * @ClassName GulimallProductApplication.java
 * @Description TODO
 * @createTime 2021/01/29 10:19:00
 */
@MapperScan("com.cxf.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }
}
