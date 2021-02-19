package com.cxf.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.product.entity.PmsCategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-29 09:56:04
 */
public interface PmsCategoryService extends IService<PmsCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查出所有分类以及子分类,  以树形结构组装起来
     * @return
     */
    List<PmsCategoryEntity> listWithTree();
}

