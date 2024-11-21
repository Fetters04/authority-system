package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Users;
import com.example.backend.service.UsersService;
import com.example.backend.mapper.UsersMapper;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
        implements UsersService {

}




