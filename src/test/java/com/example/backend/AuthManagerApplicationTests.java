package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class AuthManagerApplicationTests {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void test() {
        System.out.println(passwordEncoder.encode("123456"));
    }

}
