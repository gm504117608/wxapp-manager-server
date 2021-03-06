package com.wxapp.controller.login;

import com.wxapp.cache.RedisClient;
import com.wxapp.controller.BaseController;
import com.wxapp.model.ManagerDO;
import com.wxapp.model.ManagerDTO;
import com.wxapp.service.Response;
import com.wxapp.service.login.LoginService;
import com.wxapp.service.system.ManagerService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author guonima
 * @create 2017-06-27 17:02
 */
@RestController
public class LoginController extends BaseController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private ManagerService managerService;

    /**
     * 登录商户管理平台
     * @param mobile
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public Response login(String mobile, String password) {
        logger.info("手机号码： " + mobile);
        logger.info("密码： " + password);

        StringBuilder sb = new StringBuilder();
        if(StringUtils.isEmpty(mobile)) {
            sb.append("手机号码不能为空;");
        }
        if(StringUtils.isEmpty(mobile)) {
            sb.append("密码不能为空;");
        }
        if(sb.length() != 0) {
            return error(1000, sb.toString());
        }
        ManagerDO result = loginService.login(mobile, password);
        if(result == null || result.getMobile() == null) {
            return error(2000, "手机号码或密码错误;");
        }
        logger.debug("用户信息：" + result.toString());
        return success(managerService.cacheManagerInfo(result));
    }
}
