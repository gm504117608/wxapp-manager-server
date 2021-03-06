package com.wxapp.service.login.impl;

import com.wxapp.mapper.ManagerMapper;
import com.wxapp.model.ManagerDO;
import com.wxapp.service.base.impl.AbstractService;
import com.wxapp.service.login.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guonima
 * @create 2017-06-27 17:05
 */
@Service("loginService")
public class LoginServiceImpl extends AbstractService<ManagerDO, Long> implements LoginService {

    Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 这句必须要加上。不然会报空指针异常，因为在实际调用的时候不是BaseMapper调用，而是具体的mapper
     */
    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(managerMapper);
    }

    public ManagerDO login(String mobile, String password){
        ManagerDO param = new ManagerDO ();
        param.setMobile(mobile);
        param.setPassword(password);
        return managerMapper.find(param);
    }

}
