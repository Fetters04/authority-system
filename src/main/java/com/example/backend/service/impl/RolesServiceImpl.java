package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Roles;
import com.example.backend.service.RolesService;
import com.example.backend.mapper.RolesMapper;
import org.springframework.stereotype.Service;


@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles>
        implements RolesService {

}




