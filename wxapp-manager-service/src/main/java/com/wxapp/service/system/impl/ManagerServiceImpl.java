package com.wxapp.service.system.impl;

import com.wxapp.cache.RedisClient;
import com.wxapp.mapper.ManagerMapper;
import com.wxapp.model.ManagerDO;
import com.wxapp.service.base.impl.AbstractService;
import com.wxapp.service.system.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


/**
 * @author guonima
 * @create 2017-08-15 11:15
 */
@Service("managerService")
public class ManagerServiceImpl extends AbstractService<ManagerDO, Long> implements ManagerService {

    Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 这句必须要加上。不然会报空指针异常，因为在实际调用的时候不是BaseMapper调用，而是具体的mapper
     */
    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(managerMapper);
    }

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
        String token = UUID.randomUUID().toString() + "_" + managerDO.getId();
        try {
            RedisClient.set(token, 60 * 60 * 3, managerDO);
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("保存用户登录token到redis出现异常：", e);
        }
        return token;
    }
}
