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
    public List<UserInfo> QueryAllUsers() {
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

    public void addUserInfo(UserInfo userInfo) {
        // 使用SqlSessionFactory工具类获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        userInfoMapper.addUserInfo(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

}
