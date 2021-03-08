package com.cxf.gulimall.renren.modules.sys.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxf.gulimall.renren.modules.sys.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门Mapper接口
 *
 * @author ruoyi
 * @date 2021-03-08
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {
    /**
     * 查询部门
     *
     * @param deptId 部门ID
     * @return 部门
     */
    public SysDept selectSysDeptById(Long deptId);

    /**
     * 查询部门列表
     *
     * @param sysDept 部门
     * @return 部门集合
     */
    public List<SysDept> selectSysDeptList(SysDept sysDept);

    /**
     * 新增部门
     *
     * @param sysDept 部门
     * @return 结果
     */
    public int insertSysDept(SysDept sysDept);

    /**
     * 修改部门
     *
     * @param sysDept 部门
     * @return 结果
     */
    public int updateSysDept(SysDept sysDept);

    /**
     * 删除部门
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteSysDeptById(Long deptId);

    /**
     * 批量删除部门
     *
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysDeptByIds(Long[] deptIds);

    SysDept checkDeptNameUnique(String deptName, Long parentId);

    /**
     * 根据ID查询所有子部门
     *
     * @param deptId 部门ID
     * @return 部门列表
     */
    //public List<SysDept> selectChildrenDeptById(Long deptId);
}
