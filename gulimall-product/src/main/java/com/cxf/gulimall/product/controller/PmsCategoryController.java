package com.cxf.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxf.gulimall.product.entity.PmsCategoryEntity;
import com.cxf.gulimall.product.service.PmsCategoryService;
import com.cxf.gulimall.common.utils.PageUtils;
import com.cxf.gulimall.common.utils.R;


/**
 * 商品三级分类
 *
 * @author chaixinfeng
 * @email 18636902115@163.com
 * @date 2021-01-29 09:56:04
 */
@RestController
@RequestMapping("product/pmscategory")
public class PmsCategoryController {
    @Autowired
    private PmsCategoryService pmsCategoryService;

    @RequestMapping("/list/tree")
    public R list() {
        List<PmsCategoryEntity> list = pmsCategoryService.listWithTree();
        return R.ok().put("data", list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("product:pmscategory:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = pmsCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    @RequiresPermissions("product:pmscategory:info")
    public R info(@PathVariable("catId") Long catId) {
        PmsCategoryEntity pmsCategory = pmsCategoryService.getById(catId);

        return R.ok().put("data", pmsCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("product:pmscategory:save")
    public R save(@RequestBody PmsCategoryEntity pmsCategory) {
        pmsCategoryService.save(pmsCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("product:pmscategory:update")
    public R update(@RequestBody PmsCategoryEntity pmsCategory) {
        pmsCategoryService.updateById(pmsCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("product:pmscategory:delete")
    public R delete(@RequestBody Long[] catIds) {
        pmsCategoryService.removeByIds(Arrays.asList(catIds));
        return R.ok();
    }

    /**
     * 批量修改排序
     *
     * @param pmsCategoryArr
     * @return
     */
    @RequestMapping("/update/sort")
    public R updateSort(@RequestBody PmsCategoryEntity[] pmsCategoryArr) {
        pmsCategoryService.updateBatchById(Arrays.asList(pmsCategoryArr));
        return R.ok();
    }
}
