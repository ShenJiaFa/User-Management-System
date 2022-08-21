package com.shenjiafa.web.servlet;

import com.shenjiafa.mapper.UserLoginMapper;
import com.shenjiafa.mapper.UserMapper;
import com.shenjiafa.model.UserLogin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Mybatis基础代码
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper userLoginMapper = sqlSession.getMapper(UserLoginMapper.class);

        // 查询用户登录信息
        UserLogin userLogin = userLoginMapper.queryUserLogin(username, password);

        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        // 根据查询到的结果判断是否可以登录
        if (null != userLogin) {
            writer.write("登录成功!");
        } else {
            writer.write("登录失败!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
