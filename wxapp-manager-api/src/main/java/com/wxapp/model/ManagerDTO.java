package com.wxapp.model;

import java.io.Serializable;

/**
 * @author guonima
 * @create 2017-07-05 10:01
 */
public class ManagerDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 9293102L;

    private String name; // 用户名
    private String mobile; // 电话号码
    private String password; // 密码
    private String confirmPassword; // 确认密码
    private String avatarUrl; // 头像地址
    private Integer status; // 账号状态【0：正常， 1：无效】
    private String remark; // 备注
    private String messageAuthCode; // 短信验证码

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMessageAuthCode() {
        return messageAuthCode;
    }

    public void setMessageAuthCode(String messageAuthCode) {
        this.messageAuthCode = messageAuthCode;
    }

    @Override
    public String toString() {
        return "ManagerDTO{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", messageAuthCode='" + messageAuthCode + '\'' +
                '}';
    }
}
