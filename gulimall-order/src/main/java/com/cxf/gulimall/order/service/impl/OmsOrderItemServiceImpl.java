package com.cxf.gulimall.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.common.utils.Query;

import com.cxf.gulimall.order.dao.OmsOrderItemDao;
import com.cxf.gulimall.order.entity.OmsOrderItemEntity;
import com.cxf.gulimall.order.service.OmsOrderItemService;


@Service("omsOrderItemService")
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemDao, OmsOrderItemEntity> implements OmsOrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderItemEntity> page = this.page(
                new Query<OmsOrderItemEntity>().getPage(params),
                new QueryWrapper<OmsOrderItemEntity>()
        );

        return new PageUtils(page);
    }

}