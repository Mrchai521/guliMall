package com.cxf.gulimall.renren.modules.sys.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 部门表 sys_dept
 *
 * @author cxf
 */
@Data
@TableName("sys_dept")
public class SysDept implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 父部门ID
     */
    private Long parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    @Size(min = 0, max = 30, message = "部门名称长度不能超过30个字符")
    private String deptName;

    /**
     * 显示顺序
     */
    @NotBlank(message = "显示顺序不能为空")
    private String orderNum;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 联系电话
     */
    @Size(min = 0, max = 11, message = "联系电话长度不能超过11个字符")
    private String phone;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    private String email;

    /**
     * 部门状态:0正常,1停用
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 父部门名称
     */
    private String parentName;
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
     * 子部门
     */
    private List<SysDept> children = new ArrayList<SysDept>();

}
