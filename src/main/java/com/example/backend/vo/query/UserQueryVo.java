package com.example.backend.vo.query;

import com.example.backend.entity.User;
import lombok.Data;

@Data
public class UserQueryVo extends User {
    private Long pageNo = 1L;// 当前页码
    private Long pageSize = 10L;// 每页显示数量
}