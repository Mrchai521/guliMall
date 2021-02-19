package com.cxf.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.common.utils.Query;

import com.cxf.gulimall.product.dao.PmsCategoryDao;
import com.cxf.gulimall.product.entity.PmsCategoryEntity;
import com.cxf.gulimall.product.service.PmsCategoryService;
import org.springframework.util.StringUtils;


@Service("pmsCategoryService")
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryDao, PmsCategoryEntity> implements PmsCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsCategoryEntity> page = this.page(
                new Query<PmsCategoryEntity>().getPage(params),
                new QueryWrapper<PmsCategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查出所有分类以及子分类,  以树形结构组装起来
     */
    @Override
    public List<PmsCategoryEntity> listWithTree() {
        //查出分表的所有数据
        List<PmsCategoryEntity> list = baseMapper.selectList(null);
        //查询出所有的一级分类数据.  使用stream的api
        List<PmsCategoryEntity> firstCategoryEntity = list.stream().filter(x -> x.getParentCid() == 0).map((menu) -> {
            menu.setChildren(getChildren(menu, list));
            return menu;
        }).sorted(Comparator.comparingInt(menu -> (StringUtils.isEmpty(menu.getSort()) ? 0 : menu.getSort()))).collect(Collectors.toList());
        return firstCategoryEntity;
    }

    /**
     * 递归查询子父类
     *
     * @param root 当前节点的父id
     * @param all  所有的商品分类
     * @return
     */
    private List<PmsCategoryEntity> getChildren(PmsCategoryEntity root, List<PmsCategoryEntity> all) {
        List<PmsCategoryEntity> list = all.stream().filter(x -> x.getParentCid().equals(root.getCatId())).map(x -> {
            //子菜单还有子菜单 ，递归查询，查询出子菜单
            x.setChildren(getChildren(x, all));
            return x;
        }).sorted(Comparator.comparingInt(menu -> (StringUtils.isEmpty(menu.getSort())) ? 0 : menu.getSort())).collect(Collectors.toList());
        return list;
    }

}