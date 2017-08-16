package com.wxapp.service.system;

import com.wxapp.model.ManagerDO;

/**
 * @author guonima
 * @create 2017-08-15 11:15
 */
public interface ManagerService {

    /**
     * 保存用户注册信息并返回token值
     * @param managerDO
     * @return
     */
    public String insertManager(ManagerDO managerDO);

    public int updateManager(ManagerDO managerDO);

    /**
     * 缓存用户信息
     * @param managerDO 用户信息
     * @return 返回token值
     */
    public String cacheManagerInfo(ManagerDO managerDO);
}
