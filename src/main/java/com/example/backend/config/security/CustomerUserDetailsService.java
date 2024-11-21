package com.example.backend.config.security;

import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用根据用户名查询用户信息的方法
        User user = userService.findUserByUsername(username);

        // 认证失败
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }

        // 成功
        return user;
    }

}
