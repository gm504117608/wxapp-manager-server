package com.wxapp.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guonima
 * @create 2017-08-09 15:12
 */
@Alias("roleMenuDO")
public class RoleMenuDO extends BaseDO implements Serializable {

    private static final long serialVersionUID = -12345345L;

    private Long roleId;
    private Long menuId;
    private Date createTime;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RoleMenuDO{" +
                "roleId=" + roleId +
                ", menuId=" + menuId +
                ", createTime=" + createTime +
                '}';
    }
}
