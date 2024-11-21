package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.AuditLogs;
import com.example.backend.service.AuditLogsService;
import com.example.backend.mapper.AuditLogsMapper;
import org.springframework.stereotype.Service;


@Service
public class AuditLogsServiceImpl extends ServiceImpl<AuditLogsMapper, AuditLogs>
        implements AuditLogsService {

}




