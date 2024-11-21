package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.AuditLog;
import com.example.backend.service.AuditLogService;
import com.example.backend.mapper.AuditLogMapper;
import org.springframework.stereotype.Service;


@Service
public class AuditLogServiceImpl extends ServiceImpl<AuditLogMapper, AuditLog>
        implements AuditLogService {

}




