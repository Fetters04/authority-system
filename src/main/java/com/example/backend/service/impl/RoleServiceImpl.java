package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Role;
import com.example.backend.service.RoleService;
import com.example.backend.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
        implements RoleService {

}




