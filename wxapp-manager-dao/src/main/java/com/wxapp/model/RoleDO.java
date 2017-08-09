package com.wxapp.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author guonima
 * @create 2017-08-09 14:40
 */
@Alias("roleDO")
public class RoleDO extends BaseDO implements Serializable {

    private static final long serialVersionUID = -345345L;

    private String roleName; // 角色名称
    private String remark; // 备注
    private Integer enabled; // 是否可用【1（可用）；0（不可用）】
    private String createTime;
    private String createUser;
    private String modifyTime;
    private String modifyUser;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Override
    public String toString() {
        return "RoleDO{" +
                "roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", enabled=" + enabled +
                ", createTime='" + createTime + '\'' +
                ", createUser='" + createUser + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", modifyUser='" + modifyUser + '\'' +
                '}';
    }
}
