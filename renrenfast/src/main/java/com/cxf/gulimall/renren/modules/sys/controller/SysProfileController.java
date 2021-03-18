package com.cxf.gulimall.renren.modules.sys.controller;

import com.cxf.gulimall.renren.common.utils.R;
import com.cxf.gulimall.renren.modules.sys.entity.SysUserEntity;
import com.cxf.gulimall.renren.modules.sys.service.SysRoleService;
import com.cxf.gulimall.renren.modules.sys.service.SysUserRoleService;
import com.cxf.gulimall.renren.modules.sys.service.SysUserService;
import com.cxf.gulimall.renren.modules.sys.service.SysUserTokenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xfchai
 * @ClassName SysProfileController.java
 * @Description 个人信息业务处理
 * @createTime 2021/03/11 11:33:00
 */
@RestController
@RequestMapping("/profile")
public class SysProfileController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 个人信息
     */
    @GetMapping("/profileInfo")
    public R profile() {
        SysUserEntity user = this.getUser();
        List<Long> roldList = sysUserRoleService.queryRoleIdList(user.getUserId());
        user.setRoleIdList(roldList);
        //根据用户id获取用户所属的角色
        String roleName = sysUserService.selectUserRoleGroup(user);
        String deptName = sysUserService.selectUserPostGroup(user);
        R r = R.success(user);
        r.put("roleGroup", roleName);
        r.put("deptGroup", deptName);
        return r;
    }

    /**
     * 修改用户个人信息
     */
    @PutMapping
    public R updateProfile(@RequestBody SysUserEntity user) {
        boolean b = sysUserService.updateById(user);
        if (b) {
            //更新缓存信息
            SysUserEntity user1 = this.getUser();
            BeanUtils.copyProperties(user, user1);
            return R.success("信息修改成功！");
        }
        return R.error("修改个人信息异常，请联系管理员!");
    }
}
