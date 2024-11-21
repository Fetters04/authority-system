package com.example.backend;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class AuthManagerApplicationTests {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void test() {
        System.out.println(passwordEncoder.encode("123456"));
    }

}
