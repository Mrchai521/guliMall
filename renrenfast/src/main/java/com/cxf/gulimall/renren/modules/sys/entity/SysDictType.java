package com.cxf.gulimall.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典类型对象 sys_dict_type
 *
 * @author cxf
 * @date 2021-03-03
 */
@Data
@TableName("sys_dict_type")
public class SysDictType implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    /**
     * 字典主键
     */
    private Long dictId;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 状态（0正常 1停用）
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 备注
     */
    private String remark;

}
