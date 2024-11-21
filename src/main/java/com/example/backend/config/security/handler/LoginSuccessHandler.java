package com.example.backend.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.backend.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
 * 登录认证成功处理器类
 * */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 设置响应的编码格式
        response.setContentType("application/json;charset=utf-8");
        // 获取当前用户登录信息
        User user = (User) authentication.getPrincipal();
        // 将对象转换成 JSON 格式，并消除循环引用
        String result = JSON.toJSONString(user, SerializerFeature.DisableCircularReferenceDetect);
        // 获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

}
