package com.lanyx.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用返回类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T>  implements Serializable {

    private int code ;

    private T data;

    private String message;


    private String description;


    /**
     * 定义静态函数 (泛型静态函数) , 帮助返回公共对象 , 省去 new 的过程
     */

    //成功1 传入返回数据对象即可 , 默认返回正确码和正确消息  ---(查)
    public static <T> BaseResponse<T> success(T data) {
       return new BaseResponse<>(StatusCode.SUCCESS.getCode(), data , StatusCode.SUCCESS.getMessage(),null);
    }

    //成功2 无须返回数据对象 , 返回正确码和正确消息即可 ---(增删改)
    public static <T> BaseResponse<T> success() {
        return new BaseResponse<>(StatusCode.SUCCESS.getCode(), null , StatusCode.SUCCESS.getMessage(),null);
    }

    //错误1  返回默认错误码 , 自定义错误信息
    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<>(StatusCode.ERROR.getCode(), null,message,null);
    }
    //错误2  接收错误码对象 , 返回其错误码和错误信息
    public static <T> BaseResponse<T> error(StatusCode code) {
        return new BaseResponse<>(code.getCode(),null,code.getMessage(),null);
    }
}
