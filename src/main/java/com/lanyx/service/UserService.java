package com.lanyx.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lanyx.model.User;

import javax.servlet.http.HttpServletRequest;

/**
* @author 86186
* @description 针对表【user】的数据库操作Service
* @createDate 2023-11-21 20:14:02
*/
public interface UserService extends IService<User> {
    /**
     * 注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    Long userRegister(String userAccount , String userPassword , String checkPassword) ;

    /**
     * 登录
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */

    public User userLogin(String userAccount, String userPassword, HttpServletRequest request);

}
