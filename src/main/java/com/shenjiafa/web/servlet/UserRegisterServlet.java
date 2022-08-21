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

@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 封装UserLogin对象
        UserLogin userLogin = new UserLogin();
        userLogin.setUserName(username);
        userLogin.setPassword(password);

        // Mybatis基础代码
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper userLoginMapper = sqlSession.getMapper(UserLoginMapper.class);

        // 根据用户名查询出对应的用户登录信息
        UserLogin userLoginInfo = userLoginMapper.selectByUserName(username);

        // 如果未查询到则可以注册,如果查询到了则不可以注册
        if (null == userLoginInfo) {
            userLoginMapper.addUserLogin(userLogin);
            sqlSession.commit();
            sqlSession.close();
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("注册失败,用户名已存在!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
