package com.cxf.gulimall.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxf.gulimall.renren.modules.sys.entity.SysDictData;
import com.cxf.gulimall.renren.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典数据Mapper接口
 *
 * @author cxf
 * @date 2021-03-03
 */
@Mapper
public interface SysDictDataMapper extends BaseMapper<SysDictData> {
    /**
     * 查询字典数据
     *
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    public SysDictData selectSysDictDataById(Long dictCode);

    /**
     * 查询字典数据列表
     *
     * @param sysDictData 字典数据
     * @return 字典数据集合
     */
    public List<SysDictData> selectSysDictDataList(SysDictData sysDictData);

    /**
     * 新增字典数据
     *
     * @param sysDictData 字典数据
     * @return 结果
     */
    public int insertSysDictData(SysDictData sysDictData);

    /**
     * 修改字典数据
     *
     * @param sysDictData 字典数据
     * @return 结果
     */
    public int updateSysDictData(SysDictData sysDictData);

    /**
     * 删除字典数据
     *
     * @param dictCode 字典数据ID
     * @return 结果
     */
    public int deleteSysDictDataById(Long dictCode);

    /**
     * 批量删除字典数据
     *
     * @param dictCodes 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysDictDataByIds(Long[] dictCodes);
}
