package com.cxf.gulimall.renren.modules.sys.service;

import com.cxf.gulimall.renren.common.utils.PageUtils;
import com.cxf.gulimall.renren.modules.sys.entity.SysDictData;

import java.util.List;
import java.util.Map;

/**
 * 字典数据Service接口
 *
 * @author ruoyi
 * @date 2021-03-03
 */
public interface ISysDictDataService {
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
     * 批量删除字典数据
     *
     * @param dictCodes 需要删除的字典数据ID
     * @return 结果
     */
    public int deleteSysDictDataByIds(Long[] dictCodes);

    /**
     * 删除字典数据信息
     *
     * @param dictCode 字典数据ID
     * @return 结果
     */
    public int deleteSysDictDataById(Long dictCode);

    List<SysDictData> selectSysDictDataByDictType(String dictType);

    /**
     * 查询字典数据带分页
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);
}
