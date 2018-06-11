package com.jinstec.service.Impl;

import com.jinstec.dao.AccountMapper;
import com.jinstec.entity.Account;
import com.jinstec.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jins
 * @date on 2018/4/25.
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findById(String id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public Account findByUserName(String userName) {
        return accountMapper.selectByUserName(userName);
    }
}
