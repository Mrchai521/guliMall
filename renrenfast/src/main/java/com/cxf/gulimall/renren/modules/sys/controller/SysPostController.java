package com.cxf.gulimall.renren.modules.sys.controller;

import com.cxf.gulimall.renren.common.utils.PageUtils;
import com.cxf.gulimall.renren.common.utils.R;
import com.cxf.gulimall.renren.modules.sys.entity.SysPost;
import com.cxf.gulimall.renren.modules.sys.service.SysPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xfchai
 * @ClassName SysPostController.java
 * @Description 岗位模型的Controller
 * @createTime 2021/03/18 16:50:00
 */
@RestController
@RequestMapping("/system/post")
public class SysPostController extends AbstractController {
    @Autowired
    private SysPostService postService;

    /**
     * 获取岗位列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = postService.queryPage(params);
        return R.success("查询成功！").put("rows", page);
    }

    /**
     * 新增岗位
     *
     * @param sysPost
     * @return
     */
    @PostMapping
    public R add(@RequestBody @Validated SysPost sysPost) {
        // 校验岗位名称是否重复
        if (!postService.checkPostNameUnique(sysPost)) {
            return R.error("新增岗位'" + sysPost.getPostName() + "'失败，岗位名称已存在");
        }
        if (!postService.checkPostCodeUnique(sysPost)) {
            return R.error("新增岗位'" + sysPost.getPostCode() + "'失败，岗位编码已存在");
        }
        int insert = postService.insert(sysPost);
        return R.success("岗位新增成功！");
    }

    /**
     * 修改岗位
     *
     * @param sysPost
     * @return
     */
    @PutMapping
    public R update(@RequestBody @Validated SysPost sysPost) {
        // 校验岗位名称是否重复
        if (!postService.checkPostNameUnique(sysPost)) {
            return R.error("修改岗位'" + sysPost.getPostName() + "'失败，岗位名称已存在");
        }
        if (!postService.checkPostCodeUnique(sysPost)) {
            return R.error("修改岗位'" + sysPost.getPostCode() + "'失败，岗位编码已存在");
        }
        postService.update(sysPost);
        return R.success("岗位修改成功！");
    }

    /**
     * 删除岗位
     */
    @DeleteMapping("/{postIds}")
    public R remove(@PathVariable Long[] postIds) throws Exception {
        postService.remove(postIds);
        return R.success("删除成功！");
    }

}
