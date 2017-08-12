package com.wxapp.service.system.impl;

import com.wxapp.mapper.BaseMapper;
import com.wxapp.mapper.MenuMapper;
import com.wxapp.model.MenuDO;
import com.wxapp.service.base.impl.AbstractService;
import com.wxapp.service.system.MenuService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guonima
 * @create 2017-08-10 9:43
 */
@Service("menuService")
public class MenuServiceImpl extends AbstractService<MenuDO, Long> implements MenuService {

    Log logger = LogFactory.getLog(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 这句必须要加上。不然会报空指针异常，因为在实际调用的时候不是BaseMapper调用，而是具体的mapper
     */
    public void setBaseMapper() {
        super.setBaseMapper(menuMapper);
    }

    @Override
    public List<MenuDO> getAllMenus() {
        MenuDO menuDO = new MenuDO();
        return menuMapper.queryListAll(menuDO);
    }
}
