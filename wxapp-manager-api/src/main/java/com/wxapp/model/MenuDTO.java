package com.wxapp.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author guonima
 * @create 2017-08-10 9:57
 */
public class MenuDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -1229293102L;

    private Long id; // 菜单id
    private Long parentId; // 父级菜单
    private String name; // 菜单名称
    private Integer menuKey; // 菜单唯一标识
    private String router; // 菜单点击跳转路径
    private String icon; // 菜单图标
    private Integer level; // 菜单层级
    private Integer sort; // 菜单排序号
    private Integer enabled; // 是否可用【1（可用）；0（不可用）】
    private List<MenuDTO> children; // 子菜单

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(Integer menuKey) {
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

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<MenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDTO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", menuKey=" + menuKey +
                ", router='" + router + '\'' +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", sort=" + sort +
                ", enabled=" + enabled +
                ", children='" + children + '\'' +
                '}';
    }
}
