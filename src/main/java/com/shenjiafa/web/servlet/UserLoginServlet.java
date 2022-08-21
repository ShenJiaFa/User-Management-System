package com.shenjiafa.web.servlet;

import com.shenjiafa.mapper.UserLoginMapper;
import com.shenjiafa.model.UserLogin;
import com.shenjiafa.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Mybatis基础代码
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper userLoginMapper = sqlSession.getMapper(UserLoginMapper.class);

        // 查询用户登录信息
        UserLogin userLogin = userLoginMapper.queryUserLogin(username, password);
        sqlSession.close();
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
