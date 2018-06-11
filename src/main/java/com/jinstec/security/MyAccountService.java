package com.jinstec.security;

import com.jinstec.core.exception.UserDefinedException;
import com.jinstec.core.support.ErrorCode;
import com.jinstec.dao.AccountMapper;
import com.jinstec.dao.RoleMapper;
import com.jinstec.entity.Account;
import com.jinstec.entity.BackendAccount;
import com.jinstec.entity.Role;
import com.jinstec.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jins
 * @date on 2018/4/24.
 */
public class MyAccountService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUserName(username);
        if (account == null){
            throw new UsernameNotFoundException(username + " not exist ");
        }
        Role role = roleMapper.selectByPrimaryKey(account.getRoleId());
        Collection<GrantedAuthority> grantedAuthorities = obtainGrantedAuthority(role.getRoleName());
        BackendAccount backendAccount = new BackendAccount(account.getUserName(),account.getPassword(),grantedAuthorities);
        backendAccount.setId(account.getId());
        backendAccount.setName(account.getUserName());
        backendAccount.setRoleName(role.getRoleName());
        return backendAccount;
    }

    private Set<GrantedAuthority> obtainGrantedAuthority(String roleName){
        Set<GrantedAuthority> set = new HashSet<>();
        set.add(new SimpleGrantedAuthority("ROLE_Role_"+roleName));
        return set;
    }
}
