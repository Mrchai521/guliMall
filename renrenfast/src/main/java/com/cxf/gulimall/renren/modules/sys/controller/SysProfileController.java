package com.cxf.gulimall.renren.modules.sys.controller;

import com.cxf.gulimall.renren.common.utils.R;
import com.cxf.gulimall.renren.modules.sys.entity.SysUserEntity;
import com.cxf.gulimall.renren.modules.sys.service.SysRoleService;
import com.cxf.gulimall.renren.modules.sys.service.SysUserService;
import com.cxf.gulimall.renren.modules.sys.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xfchai
 * @ClassName SysProfileController.java
 * @Description 个人信息业务处理
 * @createTime 2021/03/11 11:33:00
 */
public class SysProfileController extends AbstractController{
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    /**
     * 个人信息
     */
    public R profile(){
        R r = R.success(this.getUser());
        //根据用户id获取用户所属的角色
        //sysRoleService.
        r.put("roleGroup",this.getUser().getUsername());
        return R.ok();
    }
}
