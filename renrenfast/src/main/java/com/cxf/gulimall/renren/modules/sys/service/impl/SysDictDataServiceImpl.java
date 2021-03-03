package com.cxf.gulimall.renren.modules.sys.service.impl;

import com.cxf.gulimall.renren.common.utils.DateUtils;
import com.cxf.gulimall.renren.modules.sys.dao.SysDictDataMapper;
import com.cxf.gulimall.renren.modules.sys.entity.SysDictData;
import com.cxf.gulimall.renren.modules.sys.service.ISysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 字典数据Service业务层处理
 *
 * @author ruoyi
 * @date 2021-03-03
 */
@Service
public class SysDictDataServiceImpl implements ISysDictDataService {
    @Autowired
    private SysDictDataMapper sysDictDataMapper;

    /**
     * 查询字典数据
     *
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    @Override
    public SysDictData selectSysDictDataById(Long dictCode) {
        return sysDictDataMapper.selectSysDictDataById(dictCode);
    }

    /**
     * 查询字典数据列表
     *
     * @param sysDictData 字典数据
     * @return 字典数据
     */
    @Override
    public List<SysDictData> selectSysDictDataList(SysDictData sysDictData) {
        return sysDictDataMapper.selectSysDictDataList(sysDictData);
    }

    /**
     * 新增字典数据
     *
     * @param sysDictData 字典数据
     * @return 结果
     */
    @Override
    public int insertSysDictData(SysDictData sysDictData) {
        sysDictData.setCreateTime(new Date());
        return sysDictDataMapper.insertSysDictData(sysDictData);
    }

    /**
     * 修改字典数据
     *
     * @param sysDictData 字典数据
     * @return 结果
     */
    @Override
    public int updateSysDictData(SysDictData sysDictData) {
        sysDictData.setUpdateTime(new Date());
        return sysDictDataMapper.updateSysDictData(sysDictData);
    }

    /**
     * 批量删除字典数据
     *
     * @param dictCodes 需要删除的字典数据ID
     * @return 结果
     */
    @Override
    public int deleteSysDictDataByIds(Long[] dictCodes) {
        return sysDictDataMapper.deleteSysDictDataByIds(dictCodes);
    }

    /**
     * 删除字典数据信息
     *
     * @param dictCode 字典数据ID
     * @return 结果
     */
    @Override
    public int deleteSysDictDataById(Long dictCode) {
        return sysDictDataMapper.deleteSysDictDataById(dictCode);
    }
}
