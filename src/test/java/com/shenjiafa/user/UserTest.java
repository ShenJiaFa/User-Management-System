package com.shenjiafa.user;

import com.shenjiafa.mapper.UserMapper;
import com.shenjiafa.model.User;
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
public class UserTest {

    @Test
    public void testQueryAllUsersByMapper() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAllUsers();
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryAllUsersByParam() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("selectAllUsers");
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryUserById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserByUserId("10003");
        System.out.println(user);
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
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectUsersByConditions(name, gender, age, address);
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryUsersByObject() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("周%");
        user.setGender("男");
        user.setAge(19);
        user.setAddress("%北京%");
        List<User> userList = userMapper.selectUsersByObject(user);
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryUsersByMap() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map userMap = new HashMap();
        userMap.put("name", "周%");
        userMap.put("gender", "男");
        userMap.put("age", 19);
        userMap.put("address", "%北京%");
        List<User> userList = userMapper.selectUsersByMap(userMap);
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testQueryUsersSingle() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setAddress("%北京%");
        List<User> userList = userMapper.selectUsersSingle(user);
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testAddUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserId("10005");
        user.setName("王亚亚");
        user.setGender("女");
        user.setAge(20);
        user.setAddress("南京市玄武区");
        userMapper.addUser(user);
        // 获取新添加user对象的id
        System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserId("10005");
        user.setName("王亚雅");
        int count = userMapper.updateUser(user);
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
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserId("10005");
        userMapper.deleteUserByUserId(user.getUserId());
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
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.deleteUserByUserIds(idList);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

}
