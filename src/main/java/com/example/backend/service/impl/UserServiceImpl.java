package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import com.example.backend.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        // 创建条件构造器对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 用户名
        queryWrapper.eq("username", username);
        // 返回查询记录
        return baseMapper.selectOne(queryWrapper);
    }
}




