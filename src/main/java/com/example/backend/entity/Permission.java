package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 *
 * @TableName sys_permission
 */
@TableName(value ="sys_permission")
@Data
public class Permission implements Serializable {
    /**
     * 权限编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    @TableField(value = "label")
    private String label;

    /**
     * 父权限ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 父权限名称
     */
    @TableField(value = "parent_name")
    private String parentName;

    /**
     * 授权标识符
     */
    @TableField(value = "code")
    private String code;

    /**
     * 路由地址
     */
    @TableField(value = "path")
    private String path;

    /**
     * 路由名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 授权路径
     */
    @TableField(value = "url")
    private String url;

    /**
     * 权限类型(0-目录 1-菜单 2-按钮)
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 是否删除(0-未删除，1-已删除)
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 子菜单列表
     */
    @JsonInclude(JsonInclude.Include.NON_NULL) //属性值为null不进行序列化操作
    @TableField(exist = false)
    private List<Permission> children = new ArrayList<Permission>();
    /**
     * 用于前端判断是菜单、目录或按钮
     */
    @TableField(exist = false)
    private String value;
    /**
     * 是否展开
     */
    @TableField(exist = false)
    private Boolean open;
}