package com.cxf.gulimall.renren.modules.sys.service.impl;

import com.cxf.gulimall.renren.common.utils.TreeSelect;
import com.cxf.gulimall.renren.modules.sys.dao.SysDeptMapper;
import com.cxf.gulimall.renren.modules.sys.entity.SysDept;
import com.cxf.gulimall.renren.modules.sys.service.SysDeptService;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author xfchai
 * @ClassName SysDeptServiceImpl.java
 * @Description 部门service实现类
 * @createTime 2021/03/08 11:06:00
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public List<SysDept> selectDeptList(SysDept dept) {
        List<SysDept> sysDepts = sysDeptMapper.selectSysDeptList(dept);
        return sysDepts;
    }

    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return
     */
    @Override
    public List<SysDept> buildDeptTree(List<SysDept> depts) {
        List<SysDept> returnList = new ArrayList<SysDept>();
        List<Long> tempList = new ArrayList<Long>();
        for (SysDept dept : depts) {
            tempList.add(dept.getDeptId());
        }
        for (Iterator<SysDept> iterator = depts.iterator(); iterator.hasNext(); ) {
            SysDept dept = (SysDept) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId())) {
                recursionFn(depts, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty()) {
            returnList = depts;
        }
        return returnList;
    }

    /**
     * 判断是否有子节点
     *
     * @param depts
     * @param tChild
     * @return
     */
    private boolean hasChild(List<SysDept> depts, SysDept tChild) {
        return this.getChildList(depts, tChild).size() > 0 ? true : false;
    }

    /**
     * 获取子节点列表
     *
     * @param depts
     * @param dept
     * @return
     */
    private List<SysDept> getChildList(List<SysDept> depts, SysDept dept) {
        List<SysDept> list = new ArrayList<>();
        for (SysDept sysDept : depts) {
            if (!StringUtils.isEmpty(sysDept.getParentId()) && dept.getDeptId().longValue() == sysDept.getParentId().longValue()) {
                list.add(sysDept);
            }
        }
        return list;
    }

    /**
     * 递归查询
     *
     * @param depts
     * @param dept
     */
    private void recursionFn(List<SysDept> depts, SysDept dept) {
        // 得到子节点列表
        List<SysDept> childList = getChildList(depts, dept);
        dept.setChildren(childList);
        for (SysDept tChild : childList) {
            if (hasChild(depts, tChild)) {
                recursionFn(depts, tChild);
            }
        }
    }

    @Override
    public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts) {
        return null;
    }

    @Override
    public List<Integer> selectDeptListByRoleId(Long roleId) {
        return null;
    }

    @Override
    public SysDept selectDeptById(Long deptId) {
        return sysDeptMapper.selectSysDeptById(deptId);
    }

    /**
     * 根据ID查询所有子部门（正常状态）
     *
     * @param deptId 部门ID
     * @return 子部门数
     */
    @Override
    public int selectNormalChildrenDeptById(Long deptId) {
        return 0;
    }

    @Override
    public boolean hasChildByDeptId(Long deptId) {
        return false;
    }

    @Override
    public boolean checkDeptExistUser(Long deptId) {
        return false;
    }

    @Override
    public Boolean checkDeptNameUnique(SysDept dept) {
        String deptName = dept.getDeptName();
        SysDept sysDept = sysDeptMapper.checkDeptNameUnique(deptName, dept.getParentId());
        if (StringUtils.isEmpty(sysDept)) {
            //如果是空，可以进行保存
            return true;
        }
        return false;
    }

    @Override
    public int insertDept(SysDept dept) throws Exception {
        SysDept info = sysDeptMapper.selectSysDeptById(dept.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if (!"0".equals(info.getStatus())) {
            throw new Exception("部门停用，不允许新增");
        }
        dept.setCreateTime(new Date());
        dept.setAncestors(info.getAncestors() + "," + dept.getParentId());
        return sysDeptMapper.insertSysDept(dept);
    }

    @Override
    public int updateDept(SysDept dept) {
        dept.setUpdateTime(new Date());
        return 0;
    }

    @Override
    public int deleteDeptById(Long deptId) {
        return sysDeptMapper.deleteSysDeptById(deptId);
    }

    @Override
    public int deleteDeptByIds(Long[] deptIds) {
        return sysDeptMapper.deleteSysDeptByIds(deptIds);
    }
}
