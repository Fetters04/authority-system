package com.example.backend.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.backend.utils.Result;
import com.example.backend.utils.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 认证用户访问无权限资源时处理器
 */
@Component
public class CustomerAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        if (response.isCommitted()) {
            // 如果响应已经提交，直接返回，避免重复写入
            return;
        }

        // 设置响应的编码格式和状态码
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        // 将对象转换成 JSON 格式，并消除循环引用
        String result = JSON.toJSONString(Result.error()
                        .code(ResultCode.NO_AUTH)
                        .message("无权限访问，请联系管理员"),
                SerializerFeature.DisableCircularReferenceDetect
        );

        // 获取输出流并写入响应
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            outputStream.write(result.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
    }
}
