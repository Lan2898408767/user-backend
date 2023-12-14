package com.lanyx.controller;

import com.lanyx.common.BaseResponse;
import com.lanyx.common.StatusCode;
import com.lanyx.constant.UserConstant;
import com.lanyx.exception.BusinessException;
import com.lanyx.model.User;
import com.lanyx.model.UserLoginRequest;
import com.lanyx.model.UserRegisterRequest;
import com.lanyx.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/*
 * ⽤户接⼝
 *
 * @author yupi
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Long> register(@RequestBody UserRegisterRequest request){
        String userAccount = request.getUserAccount();
        String userPassword = request.getUserPassword();
        String checkPassword = request.getCheckPassword();

        if(StringUtils.isAnyBlank(userAccount,userPassword,checkPassword)){
            //return null;
             throw new BusinessException(StatusCode.NULL_ERROR);
        }

        //调用service完成注册
        Long userId = userService.userRegister(request.getUserAccount(), request.getUserPassword(), request.getCheckPassword());

        return BaseResponse.success(userId) ;
    }

    @PostMapping("/login")
    public User Login(@RequestBody UserLoginRequest request , HttpServletRequest servletRequest){
        String userAccount = request.getUserAccount();
        String userPassword = request.getUserPassword();
        if(StringUtils.isAnyBlank(userAccount,userPassword)){
//            return null;
            throw new BusinessException(StatusCode.NULL_ERROR);
        }

        //调用service完成登录

        User user = userService.userLogin(request.getUserAccount(), request.getUserPassword(), servletRequest);


        return user;
    }

    @PostMapping("/logout")
    public void logout (HttpServletRequest request) {
        //移除登录态即可 (移除session)
        request.getSession().removeAttribute(UserConstant.USER_LOGIN_STATE);
    }

    @GetMapping("/currentUser")
    public User getCurrentUser(HttpServletRequest request){

        //通过key拿到session
        User user = (User)request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);

        if(user == null) {
        //   return null;
            throw new BusinessException(StatusCode.NULL_ERROR);
        }

        return user;
    }

    @GetMapping("/search")
    public List<User>  searchUser (HttpServletRequest request) {
        // 获取用户列表 (管理员查看所有用户数据)

        //TODO 判断登录态是否存在
        Object attribute = request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        User user = (User)attribute ;
        if(user == null) {
            return null;
        }
        //TODO 用户是否为管理员 userAccount == admin
        if( !("admin".equals(user.getUserAccount()))  ){
            return null ;
        }
        //满足以上条件就返回所有用户信息
        return  userService.list();

    }

    /**
     * TODO 根据id删除用户
     */

}