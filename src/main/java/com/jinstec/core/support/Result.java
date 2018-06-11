package com.jinstec.core.support;

/**
 *
 * @author fonlin
 * @date 2017/9/8
 * Result顶层
 */
public class Result {

    private int code;

    private String msg;

    public Result() {
        this(ErrorCode.OK);
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ErrorCode httpCode) {
        this.code = httpCode.code();
        this.msg = httpCode.message();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
