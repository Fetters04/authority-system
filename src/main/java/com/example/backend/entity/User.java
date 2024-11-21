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

    @TableField(value = "is_account_non_expired")
    private Integer isAccountNonExpiredDb;

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpiredDb != 1;  // 0表示正常，1表示过期
    }

    @TableField(value = "is_account_non_locked")
    private Integer isAccountNonLockedDb;

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLockedDb != 1;  // 0表示正常，1表示锁定
    }

    @TableField(value = "is_credentials_non_expired")
    private Integer isCredentialsNonExpiredDb;

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpiredDb != 1;  // 0表示正常，1表示过期
    }

    @TableField(value = "is_enabled")
    private Integer isEnabledDb;

    @Override
    public boolean isEnabled() {
        return isEnabledDb != 1;  // 0表示启用，1表示禁用
    }


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 权限列表
     */
    @TableField(exist = false)
    Collection<? extends GrantedAuthority> authorities;
}