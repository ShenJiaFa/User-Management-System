package com.shenjiafa.web.servlet;

import com.shenjiafa.pojo.UserInfo;
import com.shenjiafa.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Function:
 *
 * @author ShenJiaFa
 * @since 2022/8/27
 */
@WebServlet("/queryUserInfoByUserIdServlet")
public class QueryUserInfoByUserIdServlet extends HttpServlet {
    /**
     * 用户服务
     */
    private UserInfoService userInfoService = new UserInfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取userId
        String userId = request.getParameter("userId");
        //根据userId查询出对应的用户信息
        UserInfo userInfo = userInfoService.queryUserInfoByUserId(userId);
        // 把用户信息存入请求域中
        request.setAttribute("userInfo", userInfo);
        // 转发到userinfo.jsp
        request.getRequestDispatcher("/update_user_info.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
