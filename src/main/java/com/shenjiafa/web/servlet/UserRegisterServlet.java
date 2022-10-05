package com.shenjiafa.web.servlet;

import com.shenjiafa.mapper.UserLoginMapper;
import com.shenjiafa.pojo.UserLogin;
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

/**
 * Function: 用户注册Servlet
 *
 * @author ShenJiaFa
 * @since 2022/8/21
 */
@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");

        // 封装UserLogin对象
        UserLogin userLogin = new UserLogin();
        userLogin.setUserName(username);
        userLogin.setPassword(password);
        userLogin.setPhoneNumber(phoneNumber);

        // Mybatis基础代码
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper userLoginMapper = sqlSession.getMapper(UserLoginMapper.class);

        // 根据用户名查询出对应的用户登录信息
        UserLogin userLoginInfo = userLoginMapper.selectByUserName(username);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 如果未查询到则可以注册,如果查询到了则不可以注册
        if (null == userLoginInfo) {
            userLoginMapper.addUserLogin(userLogin);
            sqlSession.commit();
            sqlSession.close();
            writer.write("<a href=\"/user-management-system/user_login.html\">返回登录</a>" +
                    "<script>alert(\"注册成功!\")</script>");
        } else {
            writer.write("<a href=\"/user-management-system/user_register.html\">返回注册</a>" +
                    "<script>alert(\"注册失败,用户名已存在!\")</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
