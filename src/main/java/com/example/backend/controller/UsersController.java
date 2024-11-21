package com.example.backend.controller;

import com.example.backend.service.UsersService;
import com.example.backend.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Resource
    private UsersService usersService;


    @GetMapping("listAll")
    public Result listAll() {
        return Result.ok(usersService.list());
    }

}
