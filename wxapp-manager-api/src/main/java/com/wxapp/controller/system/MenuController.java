package com.wxapp.controller.system;

import com.wxapp.controller.BaseController;
import com.wxapp.model.MenuDO;
import com.wxapp.service.Response;
import com.wxapp.service.system.MenuService;
import com.wxapp.util.MenuUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单管理
 * @author guonima
 * @create 2017-08-10 9:51
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    /**
     * 获取系统所有菜单资源
     * @return
     */
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public Response getAllMenus() {
        logger.info("获取系统的所有菜单信息");
        List<MenuDO> list = menuService.getAllMenus();
        return success(MenuUtil.getMenuTree(list));
    }
}
