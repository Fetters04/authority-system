package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 审计日志表
 * @TableName audit_logs
 */
@TableName(value ="audit_logs")
@Data
public class AuditLogs implements Serializable {
    /**
     * 日志id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 操作用户 ID，关联 users.id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 用户执行的操作
     */
    @TableField(value = "action")
    private String action;

    /**
     * 操作详情（JSON 格式）
     */
    @TableField(value = "details")
    private String details;

    /**
     * 用户操作时的 IP 地址
     */
    @TableField(value = "ip_address")
    private String ipAddress;

    /**
     * 逻辑删除（0: 未删除, 1: 删除）
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 日志记录时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}