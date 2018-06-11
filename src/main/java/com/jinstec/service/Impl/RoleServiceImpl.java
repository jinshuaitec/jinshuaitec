package com.jinstec.service.Impl;

import com.jinstec.entity.Role;
import com.jinstec.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jins
 * @date on 2018/4/25.
 */
@Service("roleServiceImpl")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

/*    @Autowired
    private RoleMapper roleMapper;*/

    @Override
    public Role findById(String id) {
//        return roleMapper.selectByPrimaryKey(id);
        return null;
    }
}
