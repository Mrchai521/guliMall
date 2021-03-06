package com.cxf.gulimall.renren.modules.sys.controller;

import java.util.List;
import java.util.Map;

import com.cxf.gulimall.renren.common.utils.PageUtils;
import com.cxf.gulimall.renren.common.utils.R;
import com.cxf.gulimall.renren.modules.sys.entity.SysDictData;
import com.cxf.gulimall.renren.modules.sys.entity.SysDictType;
import com.cxf.gulimall.renren.modules.sys.service.ISysDictDataService;
import com.cxf.gulimall.renren.modules.sys.service.ISysDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private ISysDictTypeService sysDictTypeService;

    /**
     * 查询字典数据列表（带分页）
     * @RequiresPermissions("system:type:list")
     */
    @GetMapping("/listByPage")
    public R listByPage(@RequestParam Map<String, Object> params) {
        PageUtils page = sysDictDataService.queryPage(params);
        return R.ok().put("page", page);
    }
    /**
     * 查询字典数据列表
     */
    //@RequiresPermissions("system:data:list")
    @GetMapping("/list")
    public R list(SysDictData sysDictData) {
        List<SysDictData> list = sysDictDataService.selectSysDictDataList(sysDictData);
        return R.ok().put("page", list);
    }

    /**
     * 通过dictType查询列表
     */
    @GetMapping("/getListByDictType/{dictType}")
    public R getListByDicType(@PathVariable("dictType")String dictType) {
        List<SysDictData> list = sysDictDataService.selectSysDictDataByDictType(dictType);
        return R.ok().put("page",list);
    }
    /**
     * 通过字典类型id dictId获取字典数据详细信息
     * @RequiresPermissions("system:data:query")
     */
    @GetMapping(value = "/{dictId}")
    public R getDictType(@PathVariable("dictId") Long dictId) {
        SysDictType sysDictType = sysDictTypeService.selectSysDictTypeById(dictId);
        return R.ok().put("info",sysDictType);
    }
    /**
     * 获取字典数据详细信息
     * @RequiresPermissions("system:data:query")
     */

    @GetMapping(value = "type/{dictCode}")
    public R getInfo(@PathVariable("dictCode") Long dictCode) {
        return R.ok().put("info", sysDictDataService.selectSysDictDataById(dictCode));
    }

    /**
     * 新增字典数据
     *  @RequiresPermissions("system:data:add")
     */

    @PostMapping
    public R add(@RequestBody SysDictData sysDictData) {
        sysDictDataService.insertSysDictData(sysDictData);
        return R.ok("新增成功");
    }

    /**
     * 修改字典数据
     * @RequiresPermissions("system:data:edit")
     */

    @PutMapping
    public R edit(@RequestBody SysDictData sysDictData) {
        sysDictDataService.updateSysDictData(sysDictData);
        return R.ok();
    }

    /**
     * 删除字典数据
     * @RequiresPermissions("system:data:remove")
     */

    @DeleteMapping("/{dictCodes}")
    public R remove(@PathVariable Long[] dictCodes) {
        sysDictDataService.deleteSysDictDataByIds(dictCodes);
        return R.ok();
    }
}
