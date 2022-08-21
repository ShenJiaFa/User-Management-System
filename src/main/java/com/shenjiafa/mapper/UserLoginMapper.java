package com.shenjiafa.mapper;

import com.shenjiafa.model.UserLogin;
import org.apache.ibatis.annotations.Param;

/**
 * Function: UserLoginMapper类
 *
 * @author ShenJiaFa
 * @since 2022/8/21
 */
public interface UserLoginMapper {
    /**
     * 根据用户名,密码查询用户登录信息
     *
     * @param userName 用户名
     * @param password 密码
     * @return 用户登录信息
     */
    UserLogin queryUserLogin(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据用户名查询用户登录信息
     *
     * @param userName 用户名
     * @return 用户登录信息
     */
    UserLogin selectByUserName(@Param("userName") String userName);

    /**
     * 增加用户登录信息
     *
     * @param userLogin 用户登录信息
     */
    void addUserLogin(UserLogin userLogin);


}
