package com.cxf.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.order.entity.OmsOrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-28 17:52:44
 */
public interface OmsOrderSettingService extends IService<OmsOrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

