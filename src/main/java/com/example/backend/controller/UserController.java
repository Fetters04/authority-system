package com.example.backend.controller;

import com.example.backend.service.UserService;
import com.example.backend.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService usersService;


    @GetMapping("listAll")
    public Result listAll() {
        return Result.ok(usersService.list());
    }

}
