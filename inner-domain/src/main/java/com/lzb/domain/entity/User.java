package com.lzb.domain.entity;

import com.lzb.domain.base.BaseModel;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Date;

/**
 * Created by YJC on 2016-10-02.
 */
public class User extends BaseModel{

    // 用户ID
    private Long userId;
    // 用户名
    private String userName;
    // 别名
    private String nickName;
    // 年龄
    private Integer age;
    // 生日
    private Date birthday;
    // 密码
    private String userPass;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
