package com.jinstec.service;

import com.jinstec.entity.Role;

/**
 * @author jins
 * @date on 2018/4/25.
 */
public interface RoleService {

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    Role findById(String id);
}
