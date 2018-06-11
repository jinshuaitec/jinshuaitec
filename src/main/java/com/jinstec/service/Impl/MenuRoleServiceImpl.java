package com.jinstec.service.Impl;

import com.jinstec.dao.MenuRoleMapper;
import com.jinstec.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jins
 * @date on 2018/4/25.
 */
@Service("menuRoleServiceImpl")
public class MenuRoleServiceImpl implements MenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public List<String> findByRoleId(String roleId) {
        return menuRoleMapper.findByRoleId(roleId);
    }
}
