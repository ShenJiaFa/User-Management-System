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
import java.util.List;

/**
 * Function:
 *
 * @author ShenJiaFa
 * @since 2022/8/7
 */
public class QueryAllUsersTest {

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

}
