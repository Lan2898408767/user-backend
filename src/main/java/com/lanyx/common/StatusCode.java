package com.lanyx.common;

/**
 * 状态码
 * code
 * message
 * description
 */
public enum StatusCode {

    SUCCESS(1, "OK", ""),
    ERROR(0, "error", ""),
    PARAMS_ERROR(40000, "请求参数错误", ""),
    NULL_ERROR(40001, "数据为空", ""),
    NOT_LOGIN(40002, "未登录", ""),
    NO_AUTH(40003, "无权限", ""),
    SYSTEM_ERROR(400004, "系统内部异常", "");


    private final int code;

    /**
     * 状态码信息
     */
    private final String message;

    /**
     * 状态码描述（详情）
     */
    private final String description;

    StatusCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
