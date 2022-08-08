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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function:
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
        User user = userMapper.selectUserById(3L);
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



}
