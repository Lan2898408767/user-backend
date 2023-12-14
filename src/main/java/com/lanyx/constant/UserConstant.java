package com.lanyx.constant;

public interface UserConstant {

    //接口中属性默认为psf  public static final 存很多的常量

    /**
     * session的key  (记录用户登录态)
     */
   String USER_LOGIN_STATE = "user_login_state";
    /**
     * 加密盐值
     */
     String SALT = "Lanyx";

}
