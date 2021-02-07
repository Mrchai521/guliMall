package com.cxf.gulimall.member.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.cxf.gulimall.member.feign.CouponFeignService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxf.gulimall.member.entity.UmsMemberEntity;
import com.cxf.gulimall.member.service.UmsMemberService;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.common.utils.R;


/**
 * 会员
 *
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-28 17:45:30
 */
@RestController
@RequestMapping("member/umsmember")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @Autowired
    private CouponFeignService couponFeignService;

    @RequestMapping("/test")
    public R test() {
        UmsMemberEntity umsMemberEntity = new UmsMemberEntity();
        umsMemberEntity.setBirth(new Date());
        umsMemberEntity.setNickname("柴新峰");
        R r = couponFeignService.memberCoupons();
        return R.ok().put("member", umsMemberEntity).put("coupon", r.get("coupos"));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:umsmember:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = umsMemberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:umsmember:info")
    public R info(@PathVariable("id") Long id) {
        UmsMemberEntity umsMember = umsMemberService.getById(id);

        return R.ok().put("umsMember", umsMember);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:umsmember:save")
    public R save(@RequestBody UmsMemberEntity umsMember) {
        umsMemberService.save(umsMember);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:umsmember:update")
    public R update(@RequestBody UmsMemberEntity umsMember) {
        umsMemberService.updateById(umsMember);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:umsmember:delete")
    public R delete(@RequestBody Long[] ids) {
        umsMemberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
