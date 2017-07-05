package com.wxapp.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 管理平台用户信息
 * @author guonima
 * @create 2017-06-27 17:09
 */
@Alias("managerDO")
public class ManagerDO extends BaseDO implements Serializable {

    private static final long serialVersionUID = -23718973L;

    private String name; // 用户名
    private String mobile; // 电话号码
    private String password; // 密码

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ManagerDO{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
