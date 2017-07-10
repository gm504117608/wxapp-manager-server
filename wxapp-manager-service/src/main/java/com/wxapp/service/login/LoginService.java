package com.wxapp.service.login;

import com.wxapp.model.ManagerDO;

/**
 * @author guonima
 * @create 2017-06-27 17:05
 */
public interface LoginService {

    public ManagerDO login(String mobile, String password);

    public int insert(ManagerDO managerDO);

    public int update(ManagerDO managerDO);
}
