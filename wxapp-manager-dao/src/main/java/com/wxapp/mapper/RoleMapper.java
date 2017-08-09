package com.wxapp.mapper;

import com.wxapp.model.RoleDO;
import com.wxapp.model.RoleMenuDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guonima
 * @create 2017-08-09 16:10
 */
@Repository
public interface RoleMapper extends BaseMapper<RoleDO, Long> {

    public int insertBatchRoleMenus(List<RoleMenuDO> list);

    public int deleteRoleMenus(RoleMenuDO roleMenuDO);


}
