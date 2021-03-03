package com.cxf.gulimall.renren.modules.sys.service;

import com.cxf.gulimall.renren.modules.sys.entity.SysDictType;

import java.util.List;

/**
 * 字典类型Service接口
 * 
 * @author ruoyi
 * @date 2021-03-03
 */
public interface ISysDictTypeService 
{
    /**
     * 查询字典类型
     * 
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    public SysDictType selectSysDictTypeById(Long dictId);

    /**
     * 查询字典类型列表
     * 
     * @param sysDictType 字典类型
     * @return 字典类型集合
     */
    public List<SysDictType> selectSysDictTypeList(SysDictType sysDictType);

    /**
     * 新增字典类型
     * 
     * @param sysDictType 字典类型
     * @return 结果
     */
    public int insertSysDictType(SysDictType sysDictType);

    /**
     * 修改字典类型
     * 
     * @param sysDictType 字典类型
     * @return 结果
     */
    public int updateSysDictType(SysDictType sysDictType);

    /**
     * 批量删除字典类型
     * 
     * @param dictIds 需要删除的字典类型ID
     * @return 结果
     */
    public int deleteSysDictTypeByIds(Long[] dictIds);

    /**
     * 删除字典类型信息
     * 
     * @param dictId 字典类型ID
     * @return 结果
     */
    public int deleteSysDictTypeById(Long dictId);
}
