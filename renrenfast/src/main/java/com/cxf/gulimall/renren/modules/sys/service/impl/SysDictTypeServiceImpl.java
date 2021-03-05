package com.cxf.gulimall.renren.modules.sys.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxf.gulimall.renren.common.utils.PageUtils;
import com.cxf.gulimall.renren.common.utils.Query;
import com.cxf.gulimall.renren.modules.sys.dao.SysDictTypeMapper;
import com.cxf.gulimall.renren.modules.sys.dao.SysUserDao;
import com.cxf.gulimall.renren.modules.sys.entity.SysDictType;
import com.cxf.gulimall.renren.modules.sys.entity.SysUserEntity;
import com.cxf.gulimall.renren.modules.sys.service.ISysDictTypeService;
import org.apache.commons.lang.StringUtils;
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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String dictName = (String) params.get("dictName");
        String status = (String)params.get("status");
        String dictType =  (String)params.get("dictType");
        Page<SysDictType> pageDictType = new Page<>();
        String  pageNum = (String) params.get("page");
        String limit = (String)params.get("limit");
        pageDictType.setCurrent(Long.parseLong(pageNum));
        pageDictType.setSize(Long.parseLong(limit));

        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<SysDictType>()
                .like(StringUtils.isNotBlank(dictName), "dict_name", dictName)
                .like(StringUtils.isNotBlank(dictType),"dict_type",dictType)
                .eq(status != null, "status", status);
        Page<SysDictType> page = sysDictTypeMapper.selectPage(pageDictType, queryWrapper);
        return new PageUtils(page);
    }
}
