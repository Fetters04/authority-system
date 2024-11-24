package com.example.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.backend.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.vo.query.RoleQueryVo;

import java.util.List;


public interface RoleService extends IService<Role> {
    /**
     * 根据用户查询角色列表
     *
     * @param page
     * @param roleQueryVo
     * @return
     */
    IPage<Role> findRoleListByUserId(IPage<Role> page, RoleQueryVo roleQueryVo);

    /**
     * 保存角色权限关系
     *
     * @param roleId
     * @param permissionIds
     * @return
     */
    boolean saveRolePermission(Long roleId, List<Long> permissionIds);

    /**
     * 检查角色是否被使用
     *
     * @param id
     * @return
     */
    boolean hasRoleCount(Long id);

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    boolean deleteRoleById(Long id);
}
