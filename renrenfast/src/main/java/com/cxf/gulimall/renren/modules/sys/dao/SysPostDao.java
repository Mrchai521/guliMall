package com.cxf.gulimall.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxf.gulimall.renren.modules.sys.entity.SysPost;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xfchai
 * @ClassName SysPostDao.java
 * @Description 岗位dao
 * @createTime 2021/03/18 17:10:00
 */
@Mapper
public interface SysPostDao extends BaseMapper<SysPost> {
}
