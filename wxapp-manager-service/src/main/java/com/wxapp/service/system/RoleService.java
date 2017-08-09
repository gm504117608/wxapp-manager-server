package com.wxapp.service.system;

import com.wxapp.model.RoleDO;
import com.wxapp.model.RoleMenuDO;

import java.util.List;

/**
 * @author guonima
 * @create 2017-08-09 14:44
 */
public interface RoleService {

    public int save(RoleDO roleDO, List<RoleMenuDO> list);

}
