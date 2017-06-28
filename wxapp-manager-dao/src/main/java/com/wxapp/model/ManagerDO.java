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


}
