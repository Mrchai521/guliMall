package com.cxf.gulimall.renren.modules.sys.service;

import com.cxf.gulimall.renren.common.utils.PageUtils;
import com.cxf.gulimall.renren.modules.sys.entity.SysPost;

import java.util.Map;

/**
 * @author xfchai
 * @ClassName SysPostService.java
 * @Description 岗位Service
 * @createTime 2021/03/18 16:52:00
 */
public interface SysPostService {
    /**
     * 获取岗位列表
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存岗位
     * @param sysPost
     */
    void insert(SysPost sysPost);
}
