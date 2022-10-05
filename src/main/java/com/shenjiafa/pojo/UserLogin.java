package com.shenjiafa.pojo;

/**
 * Function: 用户登录信息模型类
 *
 * @author ShenJiaFa
 * @since 2022/8/21
 */
public class UserLogin {

    /**
     * 用户登录名
     */
    private String userName;

    /**
     * 用户登录密码
     */
    private String password;

    /**
     * 用户注册手机号
     */
    private String phoneNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
