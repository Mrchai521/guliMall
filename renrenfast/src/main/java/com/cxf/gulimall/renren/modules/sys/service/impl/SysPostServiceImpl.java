package com.cxf.gulimall.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxf.gulimall.renren.common.utils.PageUtils;
import com.cxf.gulimall.renren.modules.sys.dao.SysPostDao;
import com.cxf.gulimall.renren.modules.sys.entity.SysPost;
import com.cxf.gulimall.renren.modules.sys.service.SysPostService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xfchai
 * @ClassName SysPostServiceImpl.java
 * @Description 岗位ServiceImpl
 * @createTime 2021/03/18 16:52:00
 */
@Service
public class SysPostServiceImpl implements SysPostService {
    @Autowired
    private SysPostDao sysPostDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String postCode = (String) params.get("postCode");
        String postName = (String) params.get("postName");
        String status = (String) params.get("status");
        Page<SysPost> pagePost = new Page<>();
        String pageNum = (String) params.get("page");
        String limit = (String) params.get("limit");
        pagePost.setCurrent(Long.parseLong(pageNum));
        pagePost.setSize(Long.parseLong(limit));
        QueryWrapper<SysPost> queryWrapper = new QueryWrapper<SysPost>();
        queryWrapper.like(StringUtils.isNotBlank(postCode), "post_code", postCode)
                .like(StringUtils.isNotBlank(postName), "post_name", postName).eq(status != null, "status", status);
        Page<SysPost> sysPostPage = sysPostDao.selectPage(pagePost, queryWrapper);
        return new PageUtils(sysPostPage);
    }
}
