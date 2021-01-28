package com.cxf.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.member.entity.UmsMemberReceiveAddressEntity;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-28 17:45:30
 */
public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

