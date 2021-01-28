package com.cxf.gulimall.member.dao;

import com.cxf.gulimall.member.entity.UmsMemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-28 17:45:30
 */
@Mapper
public interface UmsMemberLoginLogDao extends BaseMapper<UmsMemberLoginLogEntity> {
	
}
