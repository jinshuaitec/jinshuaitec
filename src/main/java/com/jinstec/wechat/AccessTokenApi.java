package com.jinstec.wechat;

import com.jinstec.core.exception.UserDefinedException;
import com.jinstec.core.support.ErrorCode;
import com.jinstec.util.HttpUtil;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jins
 * @date on 2018/6/9.
 */
public class AccessTokenApi {

    public static AccessToken getAccessToken(){
        return getGrantAuthorization();
    }

    private static AccessToken getGrantAuthorization(){
        String url = "https://api.weixin.qq.com/cgi-bin/token";
        String appId = WeChatConfig.getAppId();
        String appSecret = WeChatConfig.getAppSecret();
        Map<String,String> map = new HashMap<>();
        map.put("grant_type","client_credential");
        map.put("appId",appId);
        map.put("secret",appSecret);
        try {
            JSONObject httpResult = HttpUtil.get(url, map);
            JSONObject jsonObject = WeChatReturnCheckKit.check(httpResult);
            return new AccessToken(jsonObject);
        }catch (IOException e){
            throw new UserDefinedException(ErrorCode.WECHAT_ERROR);
        }
    }
}
