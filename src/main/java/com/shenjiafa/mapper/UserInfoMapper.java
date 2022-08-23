package com.shenjiafa.mapper;

import com.shenjiafa.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Function: UserMapper类
 *
 * @author ShenJiaFa
 * @since 2022/8/21
 */
public interface UserInfoMapper {
    /**
     * 查询所有用户信息
     *
     * @return 用户对象列表
     */
    List<UserInfo> selectAllUserInfos();

    /**
     * 根据用户id查询用户信息
     *
     * @param userId 用户id
     * @return 用户对象
     */
    UserInfo selectUserByUserId(String userId);

    /**
     * 根据条件查询用户
     *
     * @param name    名字
     * @param gender  性别
     * @param age     年龄
     * @param address 地址
     * @return 用户信息列表
     */
    List<UserInfo> selectUsersByConditions(@Param("name") String name, @Param("gender") String gender, @Param("age") Integer age, @Param("address") String address);

    /**
     * 根据对象查询用户
     *
     * @param userInfo 用户对象
     * @return 用户对象列表
     */
    List<UserInfo> selectUsersByObject(UserInfo userInfo);

    /**
     * 根据Map查询用户列表
     *
     * @param userMap 用户Map
     * @return 用户对象列表
     */
    List<UserInfo> selectUsersByMap(Map userMap);

    /**
     * 根据单条件查询用户
     *
     * @param userInfo 用户对象
     * @return 用户对象列表
     */
    List<UserInfo> selectUsersSingle(UserInfo userInfo);

    /**
     * 添加用户信息
     *
     * @param userInfo 用户对象
     */
    void addUserInfo(UserInfo userInfo);

    /**
     * 更新用户信息
     *
     * @param userInfo 用户对象
     * @return 影响行数
     */
    int updateUser(UserInfo userInfo);

    /**
     * 根据userId删除用户
     *
     * @param userId 用户Id
     */
    void deleteUserByUserId(String userId);

    /**
     * 根据用户id列表批量删除用户
     *
     * @param idList 用户Id列表
     * @return 影响行数
     */
    int deleteUserByUserIds(@Param("userIds") List<String> idList);

}
