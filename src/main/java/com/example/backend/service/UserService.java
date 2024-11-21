package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.entity.User;


public interface UserService extends IService<User> {
    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
