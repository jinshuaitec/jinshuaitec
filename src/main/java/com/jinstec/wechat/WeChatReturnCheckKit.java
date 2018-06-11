package com.jinstec.wechat;

import com.jinstec.core.exception.UserDefinedException;
import com.jinstec.core.support.ErrorCode;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

/**
 * 检查微信返回的内容是否正确
 * @author jins
 * @date on 2018/6/9.
 */
public class WeChatReturnCheckKit {
    public static JSONObject check(JSONObject jsonObject){
        String result = jsonObject.getString("result");
        if (jsonObject.getInt("code") != org.apache.commons.httpclient.HttpStatus.SC_OK){
            throw new UserDefinedException(ErrorCode.WECHAT_ERROR);
        }
        JSONObject object = new JSONObject(result);
        if (object.has(WeChatConstants.ERR_CODE) && object.getInt(WeChatConstants.ERR_CODE) != 0){
            throw new UserDefinedException(ErrorCode.WECHAT_ERROR);
        }
        return object;
    }

}
