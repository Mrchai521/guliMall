package com.cxf.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.member.entity.UmsMemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-28 17:45:30
 */
public interface UmsMemberLoginLogService extends IService<UmsMemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

