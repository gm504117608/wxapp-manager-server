package com.wxapp.controller.system;

import com.wxapp.controller.BaseController;
import com.wxapp.controller.login.LoginController;
import com.wxapp.model.ManagerDO;
import com.wxapp.model.ManagerDTO;
import com.wxapp.service.Response;
import com.wxapp.service.system.ManagerService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author guonima
 * @create 2017-08-15 11:12
 */
@RestController
@RequestMapping("/manager")
public class ManagerController extends BaseController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ManagerService managerService;

    /**
     * 注册商户管理员用户
     * @param managerDTO
     * @return
     */
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public Response register(ManagerDTO managerDTO) {
        StringBuilder sb = new StringBuilder();
        if(StringUtils.isEmpty(managerDTO.getMobile())) {
            sb.append("手机号码不能为空");
        }
        if(StringUtils.isEmpty(managerDTO.getPassword())) {
            sb.append("密码不能为空");
        }
        if(StringUtils.isEmpty(managerDTO.getConfirmPassword())) {
            sb.append("确认密码不能为空");
        }
        if(StringUtils.isEmpty(managerDTO.getMessageAuthCode())){
            sb.append("短信验证码不能为空");
        }
        if(sb.length() != 0) {
            return error(1000, sb.toString());
        }
        if (!managerDTO.getPassword().equals(managerDTO.getConfirmPassword())) {
            sb.append("两次输入的密码不相等");
        }
        // TODO 短信验证码校验
        if(1 == 1){
            sb.append("短信验证码不正确或已经过期，请重新获取");
        }
        if(sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(managerService.insert(managerDTO2ManagerDO(managerDTO)));
    }

    /**
     * 修改商户管理员信息
     * @param managerDTO
     * @return
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Response updateManager(ManagerDTO managerDTO) {
        return success(managerService.update(managerDTO2ManagerDO(managerDTO)));
    }

    /**
     * 忘记密码
     * @param managerDTO
     * @return
     */
    @RequestMapping(value = "/forgot", method = {RequestMethod.POST})
    public Response forgotPassword(ManagerDTO managerDTO) {
        StringBuilder sb = new StringBuilder();
        if(StringUtils.isEmpty(managerDTO.getMobile())) {
            sb.append("手机号码不能为空");
        }
        if(StringUtils.isEmpty(managerDTO.getPassword())) {
            sb.append("密码不能为空");
        }
        if(StringUtils.isEmpty(managerDTO.getMessageAuthCode())){
            sb.append("短信验证码不能为空");
        }
        if(sb.length() != 0) {
            return error(1000, sb.toString());
        }
        // TODO 短信验证码校验
        if(1 == 1){
            sb.append("短信验证码不正确或已经过期，请重新获取");
        }
        if(sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(managerService.update(managerDTO2ManagerDO(managerDTO)));
    }


    /**
     * 修改密码
     * @param managerDTO
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = {RequestMethod.POST})
    public Response updatePassword(ManagerDTO managerDTO) {
        // TODO 校验 短信验证码  密码前端传加密的密文  后端直接保存
        StringBuilder sb = new StringBuilder();
        if(StringUtils.isEmpty(managerDTO.getPassword())) {
            sb.append("密码不能为空");
        }
        if(StringUtils.isEmpty(managerDTO.getMessageAuthCode())){
            sb.append("短信验证码不能为空");
        }
        if(sb.length() != 0) {
            return error(1000, sb.toString());
        }
        // TODO 短信验证码校验
        if(1 == 1){
            sb.append("短信验证码不正确或已经过期，请重新获取");
        }
        if(sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(managerService.update(managerDTO2ManagerDO(managerDTO)));
    }

    /**
     * 将商户管理员信息从界面实体转换到数据库实体
     * @param managerDTO
     * @return
     */
    private ManagerDO managerDTO2ManagerDO(ManagerDTO managerDTO) {
        ManagerDO managerDO = new ManagerDO();
        managerDO.setMobile(managerDTO.getMobile());
        managerDO.setPassword(managerDTO.getPassword());
        managerDO.setName(managerDTO.getName());
        managerDO.setStatus(managerDTO.getStatus());
        managerDO.setRemark(managerDTO.getRemark());
        managerDO.setAvatarUrl(managerDTO.getAvatarUrl());
        return managerDO;
    }
}
