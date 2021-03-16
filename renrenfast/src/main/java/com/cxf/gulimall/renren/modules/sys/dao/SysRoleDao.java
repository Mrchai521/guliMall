/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.cxf.gulimall.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxf.gulimall.renren.modules.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);


	/**
	 * 根据条件分页查询角色数据
	 *
	 * @param role 角色信息
	 * @return 角色数据集合信息
	 */
	public List<SysRoleEntity> selectRoleList(SysRoleEntity role);

	/**
	 * 根据用户ID查询角色
	 *
	 * @param userId 用户ID
	 * @return 角色列表
	 */
	public List<SysRoleEntity> selectRolePermissionByUserId(Long userId);

	/**
	 * 查询所有角色
	 *
	 * @return 角色列表
	 */
	public List<SysRoleEntity> selectRoleAll();

	/**
	 * 根据用户ID获取角色选择框列表
	 *
	 * @param userId 用户ID
	 * @return 选中角色ID列表
	 */
	public List<Integer> selectRoleListByUserId(Long userId);

	/**
	 * 通过角色ID查询角色
	 *
	 * @param roleId 角色ID
	 * @return 角色对象信息
	 */
	public SysRoleEntity selectRoleById(Long roleId);

	/**
	 * 根据用户ID查询角色
	 *
	 * @param userName 用户名
	 * @return 角色列表
	 */
	public List<SysRoleEntity> selectRolesByUserName(String userName);

	/**
	 * 校验角色名称是否唯一
	 *
	 * @param roleName 角色名称
	 * @return 角色信息
	 */
	public SysRoleEntity checkRoleNameUnique(String roleName);

	/**
	 * 校验角色权限是否唯一
	 *
	 * @param roleKey 角色权限
	 * @return 角色信息
	 */
	public SysRoleEntity checkRoleKeyUnique(String roleKey);

	/**
	 * 修改角色信息
	 *
	 * @param role 角色信息
	 * @return 结果
	 */
	public int updateRole(SysRoleEntity role);

	/**
	 * 新增角色信息
	 *
	 * @param role 角色信息
	 * @return 结果
	 */
	public int insertRole(SysRoleEntity role);

	/**
	 * 通过角色ID删除角色
	 *
	 * @param roleId 角色ID
	 * @return 结果
	 */
	public int deleteRoleById(Long roleId);

	/**
	 * 批量删除角色信息
	 *
	 * @param roleIds 需要删除的角色ID
	 * @return 结果
	 */
	public int deleteRoleByIds(Long[] roleIds);
}
