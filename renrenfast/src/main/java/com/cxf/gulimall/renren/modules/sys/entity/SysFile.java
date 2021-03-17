package com.cxf.gulimall.renren.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xfchai
 * @ClassName SysFile.java
 * @Description 系统监控 磁盘监控
 * @createTime 2021/03/17 16:50:00
 */
@Data
public class SysFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 盘符路径
     */
    private String dirName;

    /**
     * 盘符类型
     */
    private String sysTypeName;

    /**
     * 文件类型
     */
    private String typeName;

    /**
     * 总大小
     */
    private String total;

    /**
     * 剩余大小
     */
    private String free;

    /**
     * 已经使用量
     */
    private String used;

    /**
     * 资源的使用率
     */
    private double usage;
}

