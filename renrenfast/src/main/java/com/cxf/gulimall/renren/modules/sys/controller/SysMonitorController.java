package com.cxf.gulimall.renren.modules.sys.controller;

import com.cxf.gulimall.renren.common.utils.R;
import com.cxf.gulimall.renren.modules.sys.service.ISysMonitorService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author xfchai
 * @ClassName SysMonitorController.java
 * @Description 系统监控
 * @createTime 2021/03/17 16:02:00
 */
@Api(tags = "系统监控")
@Slf4j
@RestController
@RequestMapping("/system/monitor")
public class SysMonitorController {
    @Autowired
    private ISysMonitorService sysMonitorService;
    /**
     * 获取当前服务器信息
     *
     * @return
     */
    @GetMapping("/getSystemInfo")
    @ApiOperation(value = "当前服务器信息", notes = "当前服务器信息")
    public R getSystemInfo() {
        Map<String, Object> map = Maps.newHashMapWithExpectedSize(5);
        //服务器信息
        map.put("systemInfo", sysMonitorService.getSystemInfo());
        //cpu信息
        map.put("cpuInfo", sysMonitorService.getCpuInfo());
        //jvm信息
        map.put("jvmInfo", sysMonitorService.getJvmInfo());
        //内存信息
        map.put("memoryInfo", sysMonitorService.getMemoryInfo());
        //磁盘信息
        map.put("sysFileInfo", sysMonitorService.getSysFileInfo());

        return R.success("查询成功",map);
    }

    /**
     * 获取当前CPU信息
     *
     * @return
     */
    @GetMapping("/getCpuInfo")
    @ApiOperation(value = "当前CPU信息", notes = "当前CUP信息")
    public R getCpuInfo() {
        return R.success("查询成功");
    }

    /**
     * 获取当前jvm信息
     *
     * @return
     */
    @GetMapping("/getJvmInfo")
    @ApiOperation(value = "当前JVM信息", notes = "当前JVM信息")
    public R getJvmInfo() {
        return R.success("查询成功");
    }
    /**
     * 获取当前内存信息
     *
     * @return
     */
    @GetMapping("/getMemoryInfo")
    @ApiOperation(value = "当前Memory信息", notes = "当前Memory信息")
    public R getMemoryInfo() {
        return R.success("查询成功");
    }
    /**
     * 获取当前磁盘信息
     *
     * @return
     */
    @GetMapping("/sysFileInfo")
    public R sysFileInfo() {
        return R.success("查询成功");
    }
}
