package com.wxapp.controller.login;

import com.wxapp.controller.BaseController;
import com.wxapp.service.Response;
import com.wxapp.service.login.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guonima
 * @create 2017-06-27 17:02
 */
@RestController
public class LoginController extends BaseController {

    Log logger = LogFactory.getLog(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login/{name}/{password}")
    public Response login(@PathVariable("name") String name, @PathVariable("password") String password) {
        System.out.println("名称： " + name);
        System.out.println("密码： " + password);
        return success(loginService.login(name, password));
    }

}
