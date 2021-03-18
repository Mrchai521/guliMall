package com.cxf.gulimall.renren.modules.sys.controller;

import com.cxf.gulimall.renren.common.utils.PageUtils;
import com.cxf.gulimall.renren.common.utils.R;
import com.cxf.gulimall.renren.modules.sys.entity.SysDept;
import com.cxf.gulimall.renren.modules.sys.entity.SysPost;
import com.cxf.gulimall.renren.modules.sys.service.SysPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
     * 新增部门
     *
     * @param sysPost
     * @return
     */
    @PostMapping
    public R add(@RequestBody @Validated SysPost sysPost){
        postService.insert(sysPost);
        return null;
    }

}
