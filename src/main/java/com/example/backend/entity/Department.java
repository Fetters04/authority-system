package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_department
 */
@TableName(value ="sys_department")
@Data
public class Department implements Serializable {
    /**
     * 部门编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门名称
     */
    @TableField(value = "department_name")
    private String departmentName;

    /**
     * 部门电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 部门地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 所属部门编号
     */
    @TableField(value = "pid")
    private Long pid;

    /**
     * 所属部门名称
     */
    @TableField(value = "parent_name")
    private String parentName;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 是否删除(0-未删除 1-已删除)
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}