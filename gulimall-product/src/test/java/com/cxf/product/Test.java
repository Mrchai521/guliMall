package com.cxf.product;

import com.cxf.gulimall.product.entity.PmsBrandEntity;
import com.cxf.gulimall.product.service.PmsBrandService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xfchai
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2021/01/29 10:28:00
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
public class Test {
    @Autowired
    private PmsBrandService pmsBrandService;

    @org.junit.Test
    public void test() {
        PmsBrandEntity pmsBrandEntity = new PmsBrandEntity();
        pmsBrandEntity.setDescript("商品品牌");
        pmsBrandEntity.setLogo("logo.jpg");
        pmsBrandEntity.setName("AJ");
        pmsBrandEntity.setShowStatus(1);
        pmsBrandService.save(pmsBrandEntity);
    }
}
