package com.cxf.gulimall.renren.modules.sys.service.impl;

import cn.hutool.system.*;
import com.cxf.gulimall.renren.modules.sys.entity.CPU;
import com.cxf.gulimall.renren.modules.sys.entity.JVM;
import com.cxf.gulimall.renren.modules.sys.entity.Mem;
import com.cxf.gulimall.renren.modules.sys.entity.Sys;
import com.cxf.gulimall.renren.modules.sys.service.ISysMonitorService;
import org.springframework.stereotype.Service;

/**
 * @author xfchai
 * @ClassName SysMonitorServiceImpl.java
 * @Description 服务器信息ServiceImpl
 * @createTime 2021/03/17 16:28:00
 */
@Service
public class SysMonitorServiceImpl implements ISysMonitorService {
    @Override
    public Sys getSystemInfo() {
        Sys sys = new Sys();
        OsInfo osInfo = SystemUtil.getOsInfo();
        //当前主机网络地址信息
        HostInfo hostInfo = SystemUtil.getHostInfo();
        UserInfo userInfo = SystemUtil.getUserInfo();
        sys.setOsName(osInfo.getName());
        sys.setOsArch(osInfo.getArch());
        sys.setComputerIp(hostInfo.getAddress());
        sys.setUserDir(userInfo.getCurrentDir());
        return sys;
    }

    @Override
    public CPU getCpuInfo() {
        CPU cpu = new CPU();
        JavaRuntimeInfo javaRuntimeInfo = SystemUtil.getJavaRuntimeInfo();
        RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
        cpu.setCpuName( javaRuntimeInfo.getName());
        cpu.setTotal(runtimeInfo.getTotalMemory());
        cpu.setUsed(runtimeInfo.getUsableMemory());
        cpu.setFree(runtimeInfo.getFreeMemory());
        return cpu;
    }

    @Override
    public JVM getJvmInfo() {
//        JVM jvm = new JVM();
        JvmSpecInfo jvmSpecInfo = SystemUtil.getJvmSpecInfo();
        return null;
    }

    @Override
    public Mem getMemoryInfo() {
        Mem mem = new Mem();
        RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
        mem.setFree(runtimeInfo.getFreeMemory());
        mem.setTotal(runtimeInfo.getTotalMemory());
        mem.setUsage(runtimeInfo.getMaxMemory());
        mem.setUsed(runtimeInfo.getUsableMemory());
        return mem;
    }

    @Override
    public Object getSysFileInfo() {
        return null;
    }
}
