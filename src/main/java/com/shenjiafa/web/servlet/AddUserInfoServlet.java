package com.shenjiafa.web.servlet;

import com.shenjiafa.pojo.UserInfo;
import com.shenjiafa.service.UserInfoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * Function:
 *
 * @author ShenJiaFa
 * @since 2022/8/23
 */
@WebServlet("/addUserInfoServlet")
public class AddUserInfoServlet extends HttpServlet {
    /**
     * 用户服务
     */
    private UserInfoService userInfoService = new UserInfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(request.getParameter("userId"));
        userInfo.setUserName(request.getParameter("userName"));
        userInfo.setGender(request.getParameter("gender"));
        userInfo.setAge(Integer.parseInt(request.getParameter("age")));
        userInfo.setEducation(request.getParameter("education"));
        userInfo.setHeight(Double.parseDouble(request.getParameter("height")));
        userInfo.setAddress(request.getParameter("address"));
        userInfo.setHobby(Arrays.toString(request.getParameterValues("hobby")).replace("[", "").replace("]", "").replace(" ", ""));
        userInfoService.addUserInfo(userInfo);
        request.getRequestDispatcher("/queryAllUserInfosServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
