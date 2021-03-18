package com.cxf.gulimall.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xfchai
 * @ClassName SysPost.java
 * @Description 岗位实体
 * @createTime 2021/03/18 16:46:00
 */
@Data
@TableName("sys_post")
public class SysPost implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 岗位序号
     */
    @TableId
    private Long postId;

    /**
     * 岗位编码
     */
    private String postCode;

    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 岗位排序
     */
    private String postSort;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 用户是否存在此岗位标识 默认不存在
     */
    private boolean flag = false;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建人
     */
    private String updateBy;
    /**
     * 备注
     */
    private String remark;
}
