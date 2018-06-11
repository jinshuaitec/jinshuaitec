package com.jinstec.service;

import com.jinstec.entity.Account;

/**
 * @author jins
 * @date on 2018/4/25.
 */
public interface AccountService {


    /**
     * 根据id查询账号信息
     * @param id
     * @return
     */
    Account findById(String id);


    /**
     * 根据用户名查账户
     * @param userName
     * @return
     */
    Account findByUserName(String userName);
}
