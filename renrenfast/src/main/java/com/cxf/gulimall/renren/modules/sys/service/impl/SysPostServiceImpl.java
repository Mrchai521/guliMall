package com.cxf.gulimall.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxf.gulimall.renren.common.utils.PageUtils;
import com.cxf.gulimall.renren.modules.sys.dao.SysPostDao;
import com.cxf.gulimall.renren.modules.sys.entity.SysPost;
import com.cxf.gulimall.renren.modules.sys.service.SysPostService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Collection;
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

    @Override
    public int insert(SysPost sysPost) {
        int insert = sysPostDao.insert(sysPost);
        return insert;
    }

    @Override
    public boolean checkPostNameUnique(SysPost sysPost) {
        QueryWrapper<SysPost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("post_name", sysPost.getPostName());
        SysPost sysPostData = sysPostDao.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(sysPostData)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPostCodeUnique(SysPost sysPost) {
        QueryWrapper<SysPost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("post_code", sysPost.getPostName());
        SysPost sysPostData = sysPostDao.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(sysPostData)) {
            return true;
        }
        return false;
    }

    @Override
    public void update(SysPost sysPost) {
        int i = sysPostDao.updateById(sysPost);
    }

    @Override
    public int remove(Long[] postIds) throws Exception {
        for (Long postId : postIds) {
            //通过id查询岗位信息
            SysPost post = sysPostDao.selectById(postId);
            if (countUserPostById(postId) > 0) {
                throw new Exception(String.format("%1$s已分配,不能删除", post.getPostName()));
            }
        }
        return sysPostDao.deleteBatchIds(Arrays.asList(postIds.clone()));
    }

    /**
     * 通过岗位ID查询岗位使用数量
     *
     * @param postId 岗位ID
     * @return 结果
     */
    public int countUserPostById(Long postId) {
        return sysPostDao.countUserPostById(postId);
    }
}
