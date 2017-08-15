package com.wxapp.service.system.impl;

import com.wxapp.model.ManagerDO;
import com.wxapp.service.base.impl.AbstractService;
import com.wxapp.service.system.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author guonima
 * @create 2017-08-15 11:15
 */
@Service("managerService")
public class ManagerServiceImpl extends AbstractService<ManagerDO, Long> implements ManagerService {

    Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);


}
