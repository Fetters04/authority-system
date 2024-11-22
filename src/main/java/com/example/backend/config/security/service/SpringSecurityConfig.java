package com.example.backend.config.security.service;

import com.example.backend.config.security.filter.CheckTokenFilter;
import com.example.backend.config.security.handler.AnonymousAuthenticationHandler;
import com.example.backend.config.security.handler.CustomerAccessDeniedHandler;
import com.example.backend.config.security.handler.LoginFailureHandler;
import com.example.backend.config.security.handler.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Resource
    private CustomerUserDetailsService customerUserDetailsService;

    @Resource
    private LoginSuccessHandler loginSuccessHandler;

    @Resource
    private LoginFailureHandler loginFailureHandler;

    @Resource
    private AnonymousAuthenticationHandler anonymousAuthenticationHandler;

    @Resource
    private CustomerAccessDeniedHandler customerAccessDeniedHandler;

    @Resource
    private CorsConfigurationSource corsConfigurationSource;

    @Resource
    private CheckTokenFilter checkTokenFilter;

    // 密码加密器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 配置 SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 登录前进行过滤
        http.addFilterBefore(checkTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 登录过程处理
        http
                .csrf(csrf -> csrf.disable()) // 禁用 CSRF
                .cors(cors -> cors.configurationSource(corsConfigurationSource)) // 配置跨域
                .authorizeRequests(auth -> auth
                        .antMatchers("/api/user/login").permitAll() // 放行登录接口
                        .anyRequest().authenticated() // 其他请求需要认证
                )
                .formLogin(form -> form
                        .loginProcessingUrl("/api/user/login") // 设置登录 URL
                        .successHandler(loginSuccessHandler) // 登录成功处理器
                        .failureHandler(loginFailureHandler) // 登录失败处理器
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(anonymousAuthenticationHandler) // 匿名用户处理器
                        .accessDeniedHandler(customerAccessDeniedHandler) // 权限不足处理器
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 无状态会话管理
                );

        return http.build();
    }

    // 配置 AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
