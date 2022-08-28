package com.shenjiafa.service;

import com.shenjiafa.mapper.UserInfoMapper;
import com.shenjiafa.pojo.UserInfo;
import com.shenjiafa.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Function: 查询所有用户Service
 *
 * @author ShenJiaFa
 * @since 2022/8/22
 */
public class UserInfoService {
    /**
     * 查询所有用户信息
     *
     * @return 用户信息列表
     */
    public List<UserInfo> queryAllUserInfos() {
        // 使用SqlSessionFactory工具类获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 查询数据库获取userInfoList
        List<UserInfo> userInfoList = userInfoMapper.selectAllUserInfos();
        // 关闭资源
        sqlSession.close();
        return userInfoList;
    }

    /**
     * 增加用户信息
     *
     * @param userInfo 用户信息
     */
    public void addUserInfo(UserInfo userInfo) {
        // 使用SqlSessionFactory工具类获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        userInfoMapper.addUserInfo(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 根据用户id查询用户
     *
     * @param userId 用户id
     * @return 用户信息
     */
    public UserInfo queryUserInfoByUserId(String userId) {
        // 使用SqlSessionFactory工具类获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 查询数据库获取userInfo
        UserInfo userInfo = userInfoMapper.selectUserInfosByUserId(userId);
        // 关闭资源
        sqlSession.close();
        return userInfo;
    }

    /**
     * 更新用户信息
     *
     * @param userInfo 用户信息模型类
     */
    public void updateUserInfoByUserId(UserInfo userInfo) {
        // 使用SqlSessionFactory工具类获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        userInfoMapper.updateUserByUserId(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 根据用户id删除用户信息
     */
    public void delUserInfoByUserId(String userId) {
        // 使用SqlSessionFactory工具类获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        userInfoMapper.delUserInfoByUserId(userId);
        sqlSession.commit();
        sqlSession.close();
    }

}
