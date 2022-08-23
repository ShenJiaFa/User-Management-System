package com.shenjiafa.user;

import com.shenjiafa.mapper.UserInfoMapper;
import com.shenjiafa.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function: 测试增删改查用户信息
 *
 * @author ShenJiaFa
 * @since 2022/8/7
 */
public class UserInfoInfoTest {

    @Test
    public void testQueryAllUserInfosByMapper() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> userInfoList = userInfoMapper.selectAllUserInfos();
        userInfoList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryAllUsersByParam() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserInfo> userInfoList = sqlSession.selectList("selectAllUsers");
        userInfoList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryUserById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = userInfoMapper.selectUserByUserId("10003");
        System.out.println(userInfo);
        sqlSession.close();
    }

    @Test
    public void testQueryUsersByConditions() throws IOException {
        String name = "周%";
        String gender = "男";
        Integer age = 19;
        String address = "%京%";
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> userInfoList = userInfoMapper.selectUsersByConditions(name, gender, age, address);
        userInfoList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryUsersByObject() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("周%");
        userInfo.setGender("男");
        userInfo.setAge(19);
        userInfo.setAddress("%北京%");
        List<UserInfo> userInfoList = userInfoMapper.selectUsersByObject(userInfo);
        userInfoList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryUsersByMap() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        Map userMap = new HashMap();
        userMap.put("name", "周%");
        userMap.put("gender", "男");
        userMap.put("age", 19);
        userMap.put("address", "%北京%");
        List<UserInfo> userInfoList = userInfoMapper.selectUsersByMap(userMap);
        userInfoList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryUsersSingle() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setAddress("%北京%");
        List<UserInfo> userInfoList = userInfoMapper.selectUsersSingle(userInfo);
        userInfoList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testAddUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("105");
        userInfo.setUserName("陈大芳");
        userInfo.setGender("女");
        userInfo.setAge(53);
        userInfo.setAddress("江苏省南京市鸠江区");
        userInfoMapper.addUserInfo(userInfo);
        // 获取新添加user对象的id
        System.out.println(userInfo.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("10005");
        userInfo.setUserName("王亚雅");
        int count = userInfoMapper.updateUser(userInfo);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUserByUserId() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("10005");
        userInfoMapper.deleteUserByUserId(userInfo.getUserId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUserByUserIds() throws IOException {
        List<String> idList=new ArrayList<>();
        idList.add("10007");
        idList.add("10008");
        idList.add("10009");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        int count = userInfoMapper.deleteUserByUserIds(idList);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

}
