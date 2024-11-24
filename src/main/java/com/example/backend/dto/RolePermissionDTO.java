package com.example.backend.dto;

import lombok.Data;

import java.util.List;

/**
 * 用于给角色分配权限时保存 选中的权限数据
 */
@Data
public class RolePermissionDTO {
    // 角色编号
    private Long roleId;
    // 权限菜单ID集合
    private List<Long> list;
}