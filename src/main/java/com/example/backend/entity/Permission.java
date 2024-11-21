package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限表
 * @TableName permissions
 */
@TableName(value ="permissions")
@Data
public class Permission implements Serializable {
    /**
     * 权限id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 权限类型（0：目录 1：菜单 2：按钮）
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 权限唯一标识符
     */
    @TableField(value = "p_key")
    private String pKey;

    /**
     * 父权限id
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 前端路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * HTTP 方法
     */
    @TableField(value = "method")
    private Object method;

    /**
     * 权限描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time")
    private Date updatedTime;

    /**
     * 逻辑删除（0: 未删除, 1: 删除）
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}