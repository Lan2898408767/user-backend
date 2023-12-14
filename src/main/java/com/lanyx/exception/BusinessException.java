package com.lanyx.exception;
import com.lanyx.common.StatusCode;

/**
 * 自定义异常类 , 配合状态码类使用
 */
public class BusinessException extends RuntimeException {


    private static final long serialVersionUID = -4202626612835773536L;
    private final StatusCode statusCode;

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public BusinessException(StatusCode statusCode) {
       this.statusCode =statusCode;
    }


}
