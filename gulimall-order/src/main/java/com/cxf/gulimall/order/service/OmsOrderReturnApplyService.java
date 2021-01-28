package com.cxf.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.order.entity.OmsOrderReturnApplyEntity;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-28 17:52:44
 */
public interface OmsOrderReturnApplyService extends IService<OmsOrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

