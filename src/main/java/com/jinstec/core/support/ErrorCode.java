package com.jinstec.core.support;

/**
 * @author fonlin
 * @date 2017/9/8
 */
public enum ErrorCode {

    OK(0, "操作成功"),

    VALID_NOT_PASS(10, "请输入规范的数据！"),

    CANNOT_DELETE(1, "无法删除"),

    CANNOT_UPDATE(2, "无法更新"),

    BAD_REQUEST(400, "请求有异常"),

    UNAUTHORIZED(401, "未认证"),

    FORBIDDEN(403, "访问被禁止"),

    NOT_FOUND(404, "找不到资源"),

    NO_FOLLOW(777, "操作成功"),

    MSG_SUCCESS_CODE(0, "请求成功！"),

    MSG_FAIL_CODE(4000, "发送失败！"),

    MSG_FAIL_CODE_01(4001, "非法请求！"),

    MSG_FAIL_CODE_02(4002, "openid为空！"),

    TOKEN_EXCEPTION(7004, "token异常"),
    TOKEN_EXPIRED(7005, "token过期"),
    TOKEN_IS_NULL(7007, "token为空"),

    WECHAT_ERROR(900, "无法从腾讯服务器获取数据"),

    INTERNAL_SERVER_ERROR(-1, "服务器内部错误");

    int code;

    String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
