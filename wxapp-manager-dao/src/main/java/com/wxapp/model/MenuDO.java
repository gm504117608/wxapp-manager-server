package com.wxapp.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guonima
 * @create 2017-08-10 9:26
 */
@Alias("menuDO")
public class MenuDO extends BaseDO implements Serializable {

    private static final long serialVersionUID = -23115973L;

    private Long parentId; // 父级菜单
    private String name; // 菜单名称
    private String menuKey; // 菜单唯一标识
    private String router; // 菜单点击跳转路径
    private String icon; // 菜单图标
    private Integer level; // 菜单层级
    private Integer sort; // 菜单排序号
    private String remark; // 备注
    private Integer enabled; // 是否可用【1（可用）；0（不可用）】
    private Date createTime;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MenuDO{" +
                "parentId=" + parentId +
                ", name='" + name + '\'' +
                ", menuKey='" + menuKey + '\'' +
                ", router='" + router + '\'' +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", sort=" + sort +
                ", remark='" + remark + '\'' +
                ", enabled=" + enabled +
                ", createTime=" + createTime +
                '}';
    }
}
