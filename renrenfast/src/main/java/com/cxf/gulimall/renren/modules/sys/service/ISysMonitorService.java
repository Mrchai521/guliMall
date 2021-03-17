package com.cxf.gulimall.renren.modules.sys.service;

/**
 * @author xfchai
 * @ClassName ISysMonitorService.java
 * @Description 服务信息service
 * @createTime 2021/03/17 16:27:00
 */
public interface ISysMonitorService {
    Object getSystemInfo();

    Object getCpuInfo();

    Object getJvmInfo();

    Object getMemoryInfo();

    Object getSysFileInfo();
}
