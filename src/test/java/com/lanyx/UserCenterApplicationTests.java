package com.lanyx;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lanyx.model.User;
import com.lanyx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class UserCenterApplicationTests {

    /**
     * 测试mybatisPlus配置逻辑删除字段 , 配置查询数据时发现isDelete为1 , 就视为已删除 , 不返回结果集
     *
     */

    @Resource
    UserService userService;
    @Test
    public void TestIsDelete (){
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void asd(){

        String encodePassword = DigestUtils.md5DigestAsHex(("Lanyx123456789").getBytes());
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(User::getUserAccount, "root3").eq(User::getUserPassword, "956516c2ce6bf617640f1a19421eb4d9");
        System.out.println(userService.getOne(queryWrapper));
        System.out.println(userService.list());


    }



}
