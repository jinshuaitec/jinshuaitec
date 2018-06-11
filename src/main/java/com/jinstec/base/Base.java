package com.jinstec.base;

import com.jinstec.entity.BackendAccount;
import com.jinstec.util.SpringContextUtil;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author jins
 * @date on 2018/4/25.
 */
public class Base {

    protected BackendAccount getUserDetail() {
        BackendAccount backendUserDetail;
        backendUserDetail = (BackendAccount) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return backendUserDetail;
    }

}
