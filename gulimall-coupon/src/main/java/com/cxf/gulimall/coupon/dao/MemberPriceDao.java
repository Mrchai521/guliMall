package com.cxf.gulimall.coupon.dao;

import com.cxf.gulimall.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-29 11:03:43
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
