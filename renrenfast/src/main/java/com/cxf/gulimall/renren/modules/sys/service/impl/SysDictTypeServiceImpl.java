package com.cxf.gulimall.renren.modules.sys.service.impl;

import java.util.Date;
import java.util.List;

import com.cxf.gulimall.renren.modules.sys.dao.SysDictTypeMapper;
import com.cxf.gulimall.renren.modules.sys.entity.SysDictType;
import com.cxf.gulimall.renren.modules.sys.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 字典类型Service业务层处理
 *
 * @author ruoyi
 * @date 2021-03-03
 */
@Service
public class SysDictTypeServiceImpl implements ISysDictTypeService {
    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;

    /**
     * 查询字典类型
     *
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    @Override
    public SysDictType selectSysDictTypeById(Long dictId) {
        return sysDictTypeMapper.selectSysDictTypeById(dictId);
    }

    /**
     * 查询字典类型列表
     *
     * @param sysDictType 字典类型
     * @return 字典类型
     */
    @Override
    public List<SysDictType> selectSysDictTypeList(SysDictType sysDictType) {
        return sysDictTypeMapper.selectSysDictTypeList(sysDictType);
    }

    /**
     * 新增字典类型
     *
     * @param sysDictType 字典类型
     * @return 结果
     */
    @Override
    public int insertSysDictType(SysDictType sysDictType) {
        sysDictType.setCreateTime(new Date());
        return sysDictTypeMapper.insertSysDictType(sysDictType);
    }

    /**
     * 修改字典类型
     *
     * @param sysDictType 字典类型
     * @return 结果
     */
    @Override
    public int updateSysDictType(SysDictType sysDictType) {
        sysDictType.setUpdateTime(new Date());
        return sysDictTypeMapper.updateSysDictType(sysDictType);
    }

    /**
     * 批量删除字典类型
     *
     * @param dictIds 需要删除的字典类型ID
     * @return 结果
     */
    @Override
    public int deleteSysDictTypeByIds(Long[] dictIds) {
        return sysDictTypeMapper.deleteSysDictTypeByIds(dictIds);
    }

    /**
     * 删除字典类型信息
     *
     * @param dictId 字典类型ID
     * @return 结果
     */
    @Override
    public int deleteSysDictTypeById(Long dictId) {
        return sysDictTypeMapper.deleteSysDictTypeById(dictId);
    }
}
