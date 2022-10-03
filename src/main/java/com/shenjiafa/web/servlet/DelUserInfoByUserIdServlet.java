package com.shenjiafa.web.servlet;

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
@WebServlet("/delUserInfoByUserIdServlet")
public class DelUserInfoByUserIdServlet extends HttpServlet {
    /**
     * 用户服务
     */
    private UserInfoService userInfoService = new UserInfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取userId
        String userId = request.getParameter("userId");
        //根据userId删除对应数据
        userInfoService.delUserInfoByUserId(userId);
        // 转发到userinfo.jsp
        request.getRequestDispatcher("/queryAllUserInfosServlet").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
