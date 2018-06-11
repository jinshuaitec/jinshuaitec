package com.jinstec.config.Initialization;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 初始化bean,
 * @author jins
 * @date on 2018/5/27.
 */
@Service("initializationBean")
public class InitializationBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
