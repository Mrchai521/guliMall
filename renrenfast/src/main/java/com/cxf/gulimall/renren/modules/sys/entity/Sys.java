package com.cxf.gulimall.renren.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xfchai
 * @ClassName Sys.java
 * @Description 系统监控 系统信息
 * @createTime 2021/03/17 16:49:00
 */
@Data
public class Sys implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务器名称
     */
    private String computerName;

    /**
     * 服务器Ip
     */
    private String computerIp;

    /**
     * 项目路径
     */
    private String userDir;

    /**
     * 操作系统
     */
    private String osName;

    /**
     * 系统架构
     */
    private String osArch;
}

