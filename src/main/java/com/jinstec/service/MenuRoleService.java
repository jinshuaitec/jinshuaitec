package com.jinstec.service;

import java.util.List;

/**
 * @author jins
 * @date on 2018/4/25.
 */
public interface MenuRoleService {

    /**
     * 根据id获取menuId
     * @param roleId
     * @return
     */
    List<String> findByRoleId(String roleId);
}
