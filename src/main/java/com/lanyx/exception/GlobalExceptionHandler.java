package com.lanyx.exception;

import com.lanyx.common.BaseResponse;
import com.lanyx.common.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //监测自定义异常
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        //log.error("businessException: " + e.getMessage(), e);
        return BaseResponse.error(e.getStatusCode());
    }


    //检测运行时异常 (系统的其它报错)
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        //log.error("runtimeException", e);
        return BaseResponse.error(StatusCode.SYSTEM_ERROR);
    }
}
