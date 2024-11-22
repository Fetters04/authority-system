package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @TableName sys_user
 */
@TableName(value = "sys_user")
@Data
public class User implements Serializable, UserDetails {
    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录名称(用户名)
     */
    @TableField(value = "username")
    private String username;

    /**
     * 登录密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 真实姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 所属部门ID
     */
    @TableField(value = "department_id")
    private Long departmentId;

    /**
     * 所属部门名称
     */
    @TableField(value = "department_name")
    private String departmentName;

    /**
     * 性别(0-男，1-女)
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 用户头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 是否是管理员(1-管理员)
     */
    @TableField(value = "is_admin")
    private Integer isAdmin;

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
     * 是否删除(0-未删除，1-已删除)
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 帐户是否过期(1 未过期，0已过期)
     */
    private boolean isAccountNonExpired = true;
    /**
     * 帐户是否被锁定(1 未过期，0已过期)
     */
    private boolean isAccountNonLocked = true;
    /**
     * 密码是否过期(1 未过期，0已过期)
     */
    private boolean isCredentialsNonExpired = true;
    /**
     * 帐户是否可用(1 可用，0 删除用户)
     */
    private boolean isEnabled = true;
    /**
     * 权限列表
     */
    @TableField(exist = false)
    Collection<? extends GrantedAuthority> authorities;

    /**
     * 用户权限列表
     */
    @TableField(exist = false)
    private List<Permission> permissionList;
}