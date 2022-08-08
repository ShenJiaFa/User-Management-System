package com.shenjiafa.mapper;

import com.shenjiafa.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 查询所有用户信息
     *
     * @return 用户信息列表
     */
    List<User> selectAllUsers();

    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User selectUserById(long id);

    /**
     * 根据条件查询用户
     *
     * @param gender  用户性别
     * @param name    用户名字
     * @param address 用户地址
     * @return 用户信息列表
     */
    List<User> selectUsersByConditions(@Param("name") String name, @Param("gender") String gender, @Param("age") Integer age, @Param("address") String address);

    /**
     * 根据对象查询用户
     *
     * @param user 用户对象
     * @return 用户对象列表
     */
    List<User> selectUsersByObject(User user);

    /**
     * 根据Map查询用户列表
     *
     * @param userMap 用户Map
     * @return 用户信息列表
     */
    List<User> selectUsersByMap(Map userMap);

}
