package com.jinstec.dao;

import com.jinstec.entity.MenuRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * g根据角色id获取菜单
     * @param roleId
     * @return
     */
    List<String> findByRoleId(@Param("roleId") String roleId);
}