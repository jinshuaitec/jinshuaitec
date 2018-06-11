package com.jinstec.core.exception;

import com.jinstec.core.support.ErrorCode;

/**
 * @author jins
 * @date on 2018/4/16.
 */
public class UserDefinedException extends RuntimeException {

    private ErrorCode httpCode;

    public UserDefinedException (ErrorCode errorCode) {
        super();
        httpCode =  errorCode;
    }

    public UserDefinedException(ErrorCode errorCode, String msg){
        super(msg);
        this.httpCode = errorCode;
    }

    public ErrorCode getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(ErrorCode httpCode) {
        this.httpCode = httpCode;
    }
}
