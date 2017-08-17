package com.wxapp.service.system.impl;

import com.wxapp.exception.ServiceException;
import com.wxapp.mapper.RoleMapper;
import com.wxapp.model.RoleDO;
import com.wxapp.model.RoleMenuDO;
import com.wxapp.service.base.impl.AbstractService;
import com.wxapp.service.system.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guonima
 * @create 2017-08-09 14:45
 */
@Service("roleService")
public class RoleServiceImpl extends AbstractService<RoleDO, Long> implements RoleService {

    Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 这句必须要加上。不然会报空指针异常，因为在实际调用的时候不是BaseMapper调用，而是具体的mapper
     */
    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(roleMapper);
    }

    public int insertBatchRoleMenus(List<RoleMenuDO> list) {
        logger.info("批量插入角色拥有的菜单");
        try {
            return roleMapper.insertBatchRoleMenus(list);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public int deleteRoleMenus(RoleMenuDO roleMenuDO) {
        logger.info("批量删除角色拥有的菜单");
        try {
            return roleMapper.deleteRoleMenus(roleMenuDO);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public int deleteRoleMenus(Long roleId) {
        RoleMenuDO roleMenuDO = new RoleMenuDO();
        roleMenuDO.setRoleId(roleId);
        return deleteRoleMenus(roleMenuDO);
    }

    @Override
    public int save(RoleDO roleDO, List<RoleMenuDO> list) {
        Long id = roleDO.getId();
        if (null == id) {
            roleMapper.insert(roleDO);
            // 新增之后反写角色id到角色与菜单的关联对象中
            list.forEach(roleMenuDO -> roleMenuDO.setRoleId(roleDO.getId()));
        } else {
            roleMapper.update(roleDO);
            deleteRoleMenus(id);
        }
        return insertBatchRoleMenus(list);
    }

}
