package com.cxf.gulimall.member.feign;

import com.cxf.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 柴新峰
 * @date: 2021-02-07 22:47
 * @description:远程调用feign接口
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    @RequestMapping("coupon/coupon/member/list")
    public R memberCoupons();
}
