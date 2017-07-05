package com.wxapp.controller.login;

import com.wxapp.controller.BaseController;
import com.wxapp.model.ManagerDTO;
import com.wxapp.service.Response;
import com.wxapp.service.login.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author guonima
 * @create 2017-06-27 17:02
 */
@RestController
@RequestMapping("/manager")
public class LoginController extends BaseController {

    Log logger = LogFactory.getLog(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public Response login(String userName, String password) {
        logger.info("名称： " + userName);
        logger.info("密码： " + password);
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setManagerDO(loginService.login(userName, password));
        managerDTO.setToken(UUID.randomUUID().toString());
        return success(managerDTO);
    }

}
