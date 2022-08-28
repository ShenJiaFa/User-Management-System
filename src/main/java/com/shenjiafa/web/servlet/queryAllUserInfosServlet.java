package com.shenjiafa.web.servlet;

import com.shenjiafa.pojo.UserInfo;
import com.shenjiafa.service.UserInfoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * Function:
 *
 * @author ShenJiaFa
 * @since 2022/8/22
 */
@WebServlet("/queryAllUserInfosServlet")
public class queryAllUserInfosServlet extends HttpServlet {
    /**
     * 用户服务
     */
    private UserInfoService userInfoService = new UserInfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从服务层获取数据
        List<UserInfo> userInfos = userInfoService.QueryAllUserInfos();
        // 存入request域中
        request.setAttribute("userInfos", userInfos);
        // 转发到userinfo.jsp
        request.getRequestDispatcher("/user_info.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
