package com.cxf.gulimall.renren.modules.sys.controller;

import java.util.List;

import com.cxf.gulimall.renren.common.utils.R;
import com.cxf.gulimall.renren.modules.sys.entity.SysDictData;
import com.cxf.gulimall.renren.modules.sys.service.ISysDictDataService;
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
 * 字典数据Controller
 *
 * @author cxf
 * @date 2021-03-03
 */
@RestController
@RequestMapping("/system/data")
public class SysDictDataController extends AbstractController {
    @Autowired
    private ISysDictDataService sysDictDataService;

    /**
     * 查询字典数据列表
     */
    @RequiresPermissions("system:data:list")
    @GetMapping("/list")
    public R list(SysDictData sysDictData) {
        List<SysDictData> list = sysDictDataService.selectSysDictDataList(sysDictData);
        return R.ok().put("page", list);
    }

    /**
     * 导出字典数据列表
     */
    @GetMapping("/export")
    public R export(SysDictData sysDictData) {
        List<SysDictData> list = sysDictDataService.selectSysDictDataList(sysDictData);
//        ExcelUtil<SysDictData> util = new ExcelUtil<SysDictData>(SysDictData.class);
//        return util.exportExcel(list, "data");
        return R.ok();
    }

    /**
     * 获取字典数据详细信息
     */
    @RequiresPermissions("system:data:query")
    @GetMapping(value = "/{dictCode}")
    public R getInfo(@PathVariable("dictCode") Long dictCode) {
        return R.ok().put("info", sysDictDataService.selectSysDictDataById(dictCode));
    }

    /**
     * 新增字典数据
     */
    @RequiresPermissions("system:data:add")
    @PostMapping
    public R add(@RequestBody SysDictData sysDictData) {
        sysDictDataService.insertSysDictData(sysDictData);
        return R.ok("新增成功");
    }

    /**
     * 修改字典数据
     */
    @RequiresPermissions("system:data:edit")
    @PutMapping
    public R edit(@RequestBody SysDictData sysDictData) {
        sysDictDataService.updateSysDictData(sysDictData);
        return R.ok();
    }

    /**
     * 删除字典数据
     */
    @RequiresPermissions("system:data:remove")
    @DeleteMapping("/{dictCodes}")
    public R remove(@PathVariable Long[] dictCodes) {
        sysDictDataService.deleteSysDictDataByIds(dictCodes);
        return R.ok();
    }
}
