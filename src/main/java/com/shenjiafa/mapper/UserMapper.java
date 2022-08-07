package com.shenjiafa.mapper;

import com.shenjiafa.model.User;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有用户信息
     *
     * @return 用户信息列表
     */
    List<User> selectAllUsers();
}
