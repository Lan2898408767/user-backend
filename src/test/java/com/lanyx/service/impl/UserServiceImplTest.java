package com.lanyx.service.impl;

import com.lanyx.model.User;
import com.lanyx.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {


    @Resource
    UserService userService;

    /**
     * 测试mybatisPlus的整合 , 随便插入一条数据
     */
    @Test
    void contextLoads() {

        User user = new User();
        user.setUsername("Lanyx");
        user.setUserAccount("123");
        user.setAvatarUrl("123");
        user.setGender(0);
        user.setUserPassword("123");
        user.setEmail("123");
        user.setUserStatus(0);
        user.setPhone("123");

        boolean saveResult = userService.save(user);
        System.out.println("成功插入数据后将自增ID回填到User对象中 ，值为：" + user.getId());
        //断言
        Assertions.assertTrue(saveResult);
    }

    /**
     * 测试注册功能
     */
    @Test
    void userRegister() {

        long result = userService.userRegister("yupi", "123456789", "");
        Assertions.assertEquals(-1, result); // 三者有一个为空 , 预期为-1

        result = userService.userRegister("r", "123456789", "123456789");
        Assertions.assertEquals(-1, result); // 账号len小 , 预期为-1

        result = userService.userRegister("root", "123", "123" );
        Assertions.assertEquals(-1, result);// 密码len小 , 预期为-1

        result = userService.userRegister("root*r", "123456789", "123456789");
        Assertions.assertEquals(-1, result);// 账号包含特殊字符 , 预期为-1

        result = userService.userRegister("root", "123456789", "1234");
        Assertions.assertEquals(-1, result);// 两次输入的密码不一致 , 预期为-1

        result = userService.userRegister("root", "123456789", "123456789");
        Assertions.assertEquals(-1, result);// 账号名与数据库中重复 , 预期为-1
        //正确, 返回元组自增id
        Long res = userService.userRegister("root2", "123123123", "123123123");
        Assertions.assertTrue(res > 0); //预期res>0

    }


    /**
     * 测试登录
     */
    @Test
    void doLogin() {


    }
}


