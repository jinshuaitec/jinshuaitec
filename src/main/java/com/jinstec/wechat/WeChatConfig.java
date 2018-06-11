package com.jinstec.wechat;

import com.jinstec.util.StringUtil;

import java.util.ResourceBundle;

/**
 * @author jins
 * @date on 2018/6/9.
 */
public class WeChatConfig {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

    private static final String appId = resourceBundle.getString("appId");

    private static final String appSecret = resourceBundle.getString("appSecret");

    public static String getAppId(){
        if (StringUtil.isEmpty(appId)){
            throw new IllegalStateException("appId没被赋值");
        }
        return appId;
    }

    public static String getAppSecret(){
        if (StringUtil.isEmpty(appSecret)){
            throw new IllegalStateException("appSecret没被赋值");
        }
        return appSecret;
    }
}
