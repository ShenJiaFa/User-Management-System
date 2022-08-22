package com.shenjiafa.pojo;

/**
 * Function: 用户类模型
 *
 * @author ShenJiaFa
 * @since 2022/8/6
 */
public class UserInfo {
    /**
     * 序号id
     */
    private long id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户性别
     */
    private String gender;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户身高
     */
    private double height;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 数据插入时间
     */
    private String insertTime;

    /**
     * 数据更新时间
     */
    private String updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age + '\'' +
                ", height=" + height + '\'' +
                ", address='" + address + '\'' +
                ", insertTime='" + insertTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
