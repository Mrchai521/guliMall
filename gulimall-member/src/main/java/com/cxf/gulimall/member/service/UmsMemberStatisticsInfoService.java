package com.cxf.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.member.entity.UmsMemberStatisticsInfoEntity;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-28 17:45:30
 */
public interface UmsMemberStatisticsInfoService extends IService<UmsMemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

