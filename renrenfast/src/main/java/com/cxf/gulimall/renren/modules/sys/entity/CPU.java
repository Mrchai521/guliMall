package com.cxf.gulimall.renren.modules.sys.entity;

import cn.hutool.core.util.NumberUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xfchai
 * @ClassName CPU.java
 * @Description 系统监控 CPU
 * @createTime 2021/03/17 16:45:00
 */
@Data
public class CPU implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 核心名称
     */
    private String cpuName;
    /**
     * 核心数
     */
    private int cpuNum;

    /**
     * CPU总使用率
     */
    private double total;

    /**
     * CPU系统使用率
     */
    private double sys;

    /**
     * CPU用户使用率
     */
    private double used;

    /**
     * CPU当前等待率
     */
    private double wait;

    /**
     * CUP当前空闲率
     */
    private double free;

    // =================

    public double getTotal() {
        return NumberUtil.round(NumberUtil.mul(total, 100), 2).doubleValue();
    }

    public double getSys() {
        return NumberUtil.round(NumberUtil.mul(sys / total, 100), 2).doubleValue();
    }

    public double getUsed() {
        return NumberUtil.round(NumberUtil.mul(used / total, 100), 2).doubleValue();
    }

    public double getWait() {
        return NumberUtil.round(NumberUtil.mul(wait / total, 100), 2).doubleValue();
    }

    public double getFree() {
        return NumberUtil.round(NumberUtil.mul(free / total, 100), 2).doubleValue();
    }

}

