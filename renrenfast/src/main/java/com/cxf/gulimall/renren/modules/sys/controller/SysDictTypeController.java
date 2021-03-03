package com.cxf.gulimall.renren.modules.sys.controller;

import java.util.List;

import com.cxf.gulimall.renren.common.utils.R;
import com.cxf.gulimall.renren.modules.sys.entity.SysDictType;
import com.cxf.gulimall.renren.modules.sys.service.ISysDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典类型Controller
 *
 * @author cxf
 * @date 2021-03-03
 */
@RestController
@RequestMapping("/system/type")
public class SysDictTypeController extends AbstractController {
    @Autowired
    private ISysDictTypeService sysDictTypeService;

    /**
     * 查询字典类型列表
     */
    @RequiresPermissions("system:type:list")
    @GetMapping("/list")
    public R list(SysDictType sysDictType) {
        List<SysDictType> list = sysDictTypeService.selectSysDictTypeList(sysDictType);
        return R.ok().put("list", list);
    }

    /**
     * 导出字典类型列表
     */
    @RequiresPermissions("system:type:export")
    @GetMapping("/export")
    public R export(SysDictType sysDictType) {
        List<SysDictType> list = sysDictTypeService.selectSysDictTypeList(sysDictType);
//        ExcelUtil<SysDictType> util = new ExcelUtil<SysDictType>(SysDictType.class);
//        return util.exportExcel(list, "type");
        return R.ok();
    }

    /**
     * 获取字典类型详细信息
     */
    @RequiresPermissions("system:type:query")
    @GetMapping(value = "/{dictId}")
    public R getInfo(@PathVariable("dictId") Long dictId) {
        return R.ok().put("info", sysDictTypeService.selectSysDictTypeById(dictId));
    }

    /**
     * 新增字典类型
     */
    @RequiresPermissions("system:type:add")
    @PostMapping
    public R add(@RequestBody SysDictType sysDictType) {
        sysDictTypeService.insertSysDictType(sysDictType);
        return R.ok();
    }

    /**
     * 修改字典类型
     */
    @RequiresPermissions("system:type:edit")
    @PutMapping
    public R edit(@RequestBody SysDictType sysDictType) {
        sysDictTypeService.updateSysDictType(sysDictType);
        return R.ok("修改成功！");
    }

    /**
     * 删除字典类型
     */
    @RequiresPermissions("system:type:remove")
    @DeleteMapping("/{dictIds}")
    public R remove(@PathVariable Long[] dictIds) {
        sysDictTypeService.deleteSysDictTypeByIds(dictIds);
        return R.ok("删除成功！");
    }
}
