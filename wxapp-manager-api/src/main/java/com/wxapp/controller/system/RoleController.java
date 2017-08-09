package com.wxapp.controller.system;

import com.wxapp.controller.BaseController;
import com.wxapp.model.RoleDO;
import com.wxapp.model.RoleDTO;
import com.wxapp.model.RoleMenuDO;
import com.wxapp.service.Response;
import com.wxapp.service.system.RoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色信息管理
 * @author guonima
 * @create 2017-08-09 14:31
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    Log logger = LogFactory.getLog(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 角色管理操作
     * @param roleDTO
     * @return
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Response save(RoleDTO roleDTO) {
        roleService.save(roleDTO2RoleDO(roleDTO), roleDTO2RoleMenuDO(roleDTO));
        return success(null);
    }

    private RoleDO roleDTO2RoleDO (RoleDTO roleDTO) {
        RoleDO roleDO = new RoleDO();
        roleDO.setId(roleDTO.getId());
        roleDO.setRoleName(roleDTO.getRoleName());
        roleDO.setRemark(roleDTO.getRemark());
        roleDO.setEnabled(roleDTO.getEnabled());
        return roleDO;
    }

    private List<RoleMenuDO> roleDTO2RoleMenuDO (RoleDTO roleDTO) {
        List<RoleMenuDO> list = new ArrayList<RoleMenuDO>();
        RoleMenuDO roleMnuDO = null;
        List<Long> menuIds = roleDTO.getMenuId();
        Long roleId = roleDTO.getId();
        for (Long menuId : menuIds) {
            roleMnuDO = new RoleMenuDO();
            roleMnuDO.setMenuId(menuId);
            roleMnuDO.setRoleId(roleId);
            list.add(roleMnuDO);
        }
        return list;
    }
}
