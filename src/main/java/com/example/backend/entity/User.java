package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable, UserDetails {
    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 用户状态（0: 禁用, 1: 启用）
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 用户头像
     */
    @TableField(value = "avatar")
    private String avatar;

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

    /**
     * 帐户是否过期(0-未过期，1-已过期)
     */
    @TableField(value = "is_account_non_expired")
    private boolean isAccountNonExpired;

    /**
     * 帐户是否被锁定(0-未锁定，1-已锁定)
     */
    @TableField(value = "is_account_non_locked")
    private boolean isAccountNonLocked;

    /**
     * 密码是否过期(0-未过期，1-已过期)
     */
    @TableField(value = "is_credentials_non_expired")
    private boolean isCredentialsNonExpired;

    /**
     * 帐户是否可用(0-可用，1-禁用)
     */
    @TableField(value = "is_enabled")
    private boolean isEnabled;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 权限列表
     */
    @TableField(exist = false)
    Collection<? extends GrantedAuthority> authorities;
}