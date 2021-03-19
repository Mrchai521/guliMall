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
     *
     * @param sysPost
     */
    int insert(SysPost sysPost);

    /**
     * 校验岗位名称是否唯一
     *
     * @param sysPost
     * @return
     */
    boolean checkPostNameUnique(SysPost sysPost);

    /**
     * 校验编码名称是否唯一
     *
     * @param sysPost
     * @return
     */
    boolean checkPostCodeUnique(SysPost sysPost);

    /**
     * 修改岗位
     *
     * @param sysPost
     */
    void update(SysPost sysPost);

    /**
     * 删除岗位
     *
     * @param postIds
     * @return
     */
    int remove(Long[] postIds) throws Exception;
}
