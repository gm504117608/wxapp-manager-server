package com.wxapp.service.system.impl;

import com.wxapp.cache.RedisClient;
import com.wxapp.model.ManagerDO;
import com.wxapp.service.base.impl.AbstractService;
import com.wxapp.service.system.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;


/**
 * @author guonima
 * @create 2017-08-15 11:15
 */
@Service("managerService")
public class ManagerServiceImpl extends AbstractService<ManagerDO, Long> implements ManagerService {

    Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

    @Override
    public String insertManager(ManagerDO managerDO) {
        super.insert(managerDO);
        return cacheManagerInfo(managerDO);
    }

    @Override
    public int updateManager(ManagerDO managerDO) {
        super.insert(managerDO);
        cacheManagerInfo(managerDO);
        return 0;
    }

    @Override
    public String cacheManagerInfo(ManagerDO managerDO) {
        String token = UUID.randomUUID().toString();
        try {
            RedisClient.set(token + "_" + managerDO.getId(), 60 * 60 * 3, managerDO);
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("保存用户登录token到redis出现异常：", e);
        }
        return token;
    }
}
