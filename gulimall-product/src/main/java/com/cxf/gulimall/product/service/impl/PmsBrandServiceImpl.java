package com.cxf.gulimall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.common.utils.Query;

import com.cxf.gulimall.product.dao.PmsBrandDao;
import com.cxf.gulimall.product.entity.PmsBrandEntity;
import com.cxf.gulimall.product.service.PmsBrandService;


@Service("pmsBrandService")
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandDao, PmsBrandEntity> implements PmsBrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsBrandEntity> page = this.page(
                new Query<PmsBrandEntity>().getPage(params),
                new QueryWrapper<PmsBrandEntity>()
        );

        return new PageUtils(page);
    }

}