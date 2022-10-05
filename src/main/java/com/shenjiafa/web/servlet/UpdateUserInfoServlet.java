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
@WebServlet("/updateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
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
        userInfo.setHobby(request.getParameter("hobby"));
        userInfo.setAddress(request.getParameter("address"));
        userInfoService.updateUserInfoByUserId(userInfo);
        request.getRequestDispatcher("/queryAllUserInfosServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
