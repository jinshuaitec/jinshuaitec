package com.jinstec.wechat;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * @author jins
 * @date on 2018/6/9.
 */
@SuppressWarnings("unchecked")
public class AccessToken implements Serializable {

    private static final long serialVersionUID = -822464425433824314L;

    private String accessToken;

    private String errMsg;

    private Integer expiresIn;

    private Integer errCode;

    private Long expiredTime;

    public AccessToken (JSONObject jsonObject){
        if (jsonObject.has(WeChatConstants.ERR_CODE)){
            accessToken = jsonObject.getString(WeChatConstants.ACCESS_TOKEN);
            expiresIn = jsonObject.getInt(WeChatConstants.EXPIRES_IN);
            expiredTime = System.currentTimeMillis()+(expiresIn -5) * 1000;
        }else {
            errCode = jsonObject.getInt(WeChatConstants.ERR_CODE);
            errMsg = jsonObject.getString(WeChatConstants.ERR_MSG);
        }
    }

    /**
     * 计算当前access_token是否有效
     * @return 是否有效
     */
    public boolean isAvailable() {
        return !(expiredTime == null || errCode != null || expiredTime < System.currentTimeMillis());
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
