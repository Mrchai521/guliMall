package com.cxf.gulimall.ware.dao;

import com.cxf.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-29 11:31:48
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
