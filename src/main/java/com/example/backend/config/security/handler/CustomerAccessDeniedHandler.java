package com.example.backend.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.backend.entity.User;
import com.example.backend.utils.Result;
import com.example.backend.utils.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 认证用户访问无权限资源时处理器
 */
@Component
public class CustomerAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 设置响应的编码格式
        response.setContentType("application/json;charset=utf-8");
        // 将对象转换成 JSON 格式，并消除循环引用
        String result = JSON.toJSONString(Result.error().code(ResultCode.NO_AUTH).message("无权限访问，请联系管理员"), SerializerFeature.DisableCircularReferenceDetect);
        // 获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 结果保存到输出中写出
        outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
