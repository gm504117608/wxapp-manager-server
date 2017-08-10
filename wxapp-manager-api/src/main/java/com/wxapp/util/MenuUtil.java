package com.wxapp.util;

import com.wxapp.model.MenuDO;
import com.wxapp.model.MenuDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 菜单处理工具类
 *
 * @author guonima
 * @create 2017-08-10 10:28
 */
public class MenuUtil {

    /**
     * 菜单传输实体和数据库实体转换
     *
     * @param menuDTO 界面显示实体
     * @param menuDO  数据库实体
     */
    public static void MenuDO2MenuDTO(MenuDTO menuDTO, MenuDO menuDO) {
        menuDTO.setId(menuDO.getId());
        menuDTO.setParentId(menuDO.getParentId());
        menuDTO.setName(menuDO.getName());
        menuDTO.setMenuKey(menuDO.getMenuKey());
        menuDTO.setRouter(menuDO.getRouter());
        menuDTO.setEnabled(menuDO.getEnabled());
        menuDTO.setIcon(menuDO.getIcon());
        menuDTO.setSort(menuDO.getSort());
        menuDTO.setLevel(menuDO.getLevel());
    }

    public static void MenuDO2MenuDTO(List<MenuDTO> menuDTOList, List<MenuDO> menuDOList) {
        MenuDTO menuDTO = null;
        for (MenuDO menuDO : menuDOList) {
            menuDTO = new MenuDTO();
            MenuDO2MenuDTO(menuDTO, menuDO);
            menuDTOList.add(menuDTO);
        }
    }

    /**
     * 获取界面显示菜单树要求的数据格式
     *
     * @param list
     * @return
     */
    public static List<MenuDTO> getMenuTree(List<MenuDO> list) {
        List<MenuDTO> menuDTOList = new ArrayList<MenuDTO>();
        MenuDO2MenuDTO(menuDTOList, list);
        return getMenuTree(menuDTOList, null);
    }

    /**
     * 获取界面显示菜单树要求的数据格式
     *
     * @param list
     * @param parentId
     * @return
     */
    public static List<MenuDTO> getMenuTree(List<MenuDTO> list, Long parentId) {
        return getChildMenus(list, parentId);
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list     具有树形结构特点的集合
     * @param parentId 父节点ID
     * @return 树形结构集合
     */
    public static List<MenuDTO> getChildMenus(List<MenuDTO> list, Long parentId) {
        List<MenuDTO> returnList = new ArrayList<MenuDTO>();
        for (Iterator<MenuDTO> iterator = list.iterator(); iterator.hasNext(); ) {
            MenuDTO t = iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param menuDTO
     */
    private static void recursionFn(List<MenuDTO> list, MenuDTO menuDTO) {
        List<MenuDTO> childList = getChildList(list, menuDTO);// 得到子节点列表
        menuDTO.setChildren(childList);
        for (MenuDTO child : childList) {
            if (hasChild(list, child)) {// 判断是否有子节点
                Iterator<MenuDTO> it = childList.iterator();
                while (it.hasNext()) {
                    MenuDTO n = (MenuDTO) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     *
     * @param list
     * @param menuDTO
     * @return
     */
    private static List<MenuDTO> getChildList(List<MenuDTO> list, MenuDTO menuDTO) {
        List<MenuDTO> children = new ArrayList<MenuDTO>();
        Iterator<MenuDTO> it = list.iterator();
        MenuDTO temp = null;
        while (it.hasNext()) {
            temp = (MenuDTO) it.next();
            if (menuDTO.getId() == temp.getParentId()) {
                children.add(temp);
            }
        }
        return children;
    }

    /**
     * 判断是否有子节点
     *
     * @param list
     * @param menuDTO
     * @return
     */
    private static boolean hasChild(List<MenuDTO> list, MenuDTO menuDTO) {
        return getChildList(list, menuDTO).size() > 0 ? true : false;
    }
}
