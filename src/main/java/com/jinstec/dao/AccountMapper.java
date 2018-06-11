package com.jinstec.dao;

import com.jinstec.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper extends BaseMapper<Account>{

    /**
     * 根据用户名查询账户
     * @param userName
     * @return
     */
    Account selectByUserName(@Param("userName") String userName);
}