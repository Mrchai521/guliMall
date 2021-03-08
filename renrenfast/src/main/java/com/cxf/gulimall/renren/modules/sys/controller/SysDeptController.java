package com.cxf.gulimall.renren.modules.sys.controller;

import com.cxf.gulimall.renren.common.utils.R;
import com.cxf.gulimall.renren.modules.sys.entity.SysDept;
import com.cxf.gulimall.renren.modules.sys.service.SysDeptService;
import io.swagger.annotations.OAuth2Definition;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xfchai
 * @ClassName SysDeptController.java
 * @Description 部门controller
 * @createTime 2021/03/08 10:46:00
 */
@RestController
@RequestMapping("/system/dept")
public class SysDeptController extends AbstractController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 部门列表
     *
     * @param sysDept
     * @return
     */
    @GetMapping("/list")
    public R list(SysDept sysDept) {
        List<SysDept> list = sysDeptService.selectDeptList(sysDept);
        List<SysDept> sysDepts = sysDeptService.buildDeptTree(list);
        return R.ok().put("page", sysDepts);
    }

    /**
     * 查询部门列表（排除节点）
     */
    @GetMapping("/list/exclude/{deptId}")
    public R excludeChild(@PathVariable(value = "deptId", required = false) Long deptId) {
        List<SysDept> listDept = sysDeptService.selectDeptList(new SysDept());
        List<SysDept> depts = sysDeptService.buildDeptTree(listDept);
        List<SysDept> list = new ArrayList<>();
        for (SysDept sysDept : depts) {
            if (sysDept.getDeptId().longValue() == deptId || ArrayUtils.contains(StringUtils.split(sysDept.getAncestors(),
                    ","), deptId + "")) {
                continue;
            } else {
                list.add(sysDept);
            }
        }
        return R.ok().put("page", depts);
    }

    /**
     * 根据部门编号获取详细信息
     */
    @GetMapping(value = "/{deptId}")
    public R getInfo(@PathVariable Long deptId) {
        SysDept sysDept = sysDeptService.selectDeptById(deptId);
        return R.ok().put("page", sysDept);
    }

    /**
     * 新增部门
     *
     * @param sysDept
     * @return
     */
    @PostMapping
    public R add(@RequestBody @Validated SysDept sysDept) throws Exception {
        Boolean nameUnique = sysDeptService.checkDeptNameUnique(sysDept);
        if (!nameUnique) {
            return R.error("新增失败，部门" + sysDept.getDeptName() + "已存在");
        }
        int i = sysDeptService.insertDept(sysDept);
        return R.ok("新增成功");
    }

    /**
     * 修改
     *
     * @param sysDept
     * @return
     */
    @PutMapping
    public R update(@RequestBody @Validated SysDept sysDept) {
        sysDept.setUpdateBy(this.getUser().getUsername());
        int i = sysDeptService.updateDept(sysDept);
        return R.ok("修改成功");
    }

    /**
     * 删除
     *
     * @param deptIds
     * @return
     */
    @DeleteMapping("/{deptIds}")
    public R delete(@PathVariable Long[] deptIds) {
        int i = sysDeptService.deleteDeptByIds(deptIds);
        return R.ok("删除成功");
    }
}
