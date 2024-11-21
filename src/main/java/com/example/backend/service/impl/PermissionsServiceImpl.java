package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Permissions;
import com.example.backend.service.PermissionsService;
import com.example.backend.mapper.PermissionsMapper;
import org.springframework.stereotype.Service;


@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions>
        implements PermissionsService {

}




