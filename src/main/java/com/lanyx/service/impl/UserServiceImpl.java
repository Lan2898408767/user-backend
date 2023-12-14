package com.lanyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanyx.common.StatusCode;
import com.lanyx.constant.UserConstant;
import com.lanyx.exception.BusinessException;
import com.lanyx.mapper.UserMapper;
import com.lanyx.model.User;
import com.lanyx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * @author 86186
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-11-21 20:14:02
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public Long userRegister(String userAccount, String userPassword, String checkPassword) {
        //全部非空
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
           throw new BusinessException(StatusCode.NULL_ERROR);
        }
        //账号长度<8 ，命名规范(含特殊字符) , 直接返回-1错误码
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        if (userAccount.length() < 4 || Pattern.compile(regEx).matcher(userAccount).find()) {
            return -1L;
        }
        //密码长度
        if (userPassword.length() < 8) {
            return -1L;
        }
        //两个密码需要一致
        if (!userPassword.equals(checkPassword)) {
            return -1L;
        }
        //账号应与数据库中无重复
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserAccount, userAccount);
        User one = this.getOne(queryWrapper);
        if (one != null) {
            return -1L;
        }

        //满足校验 ，进行数据插入
        //1.密码加密 ,加盐
        String password = DigestUtils.md5DigestAsHex((UserConstant.SALT + userPassword).getBytes());
        //2.插入数据
        User user = User.builder()
                .userAccount(userAccount)
                .userPassword(password)
                .build();
        boolean saveResult = this.save(user);

        if (!saveResult) {
            return -1L;
        }
        return user.getId();
        //mybatisplus的机制 ，会将数据库生成的自增id返回到User中

    }

    @Override
    public User userLogin(String userAccount, String userPassword,  HttpServletRequest request) {
        // 1.校验用户的账户、密码是否符合要求
        // 1.1.非空校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        // 1.2. 账户长度不小于4位
        if (userAccount.length() < 4) {
            return null;
        }
        // 1.3. 密码就不小于8位
        if (userPassword.length() < 8) {
            return null;
        }
        // 1.4. 账户不包含特殊字符
        String validRule = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%…… &*（）——+ | {}【】‘；：”“’。，、？]";
        // 如果包含非法字符，则返回
        if (Pattern.compile(validRule).matcher(userAccount).find()) {
            return null;
        }

        // 2.查询用户名和密码所匹配的用户
        String encodePassword = DigestUtils.md5DigestAsHex((UserConstant.SALT + userPassword).getBytes());
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // select * from user where userAccount=userAccount and userPassword = encodePassword
        // 这里存在bug：会把逻辑删除的用户查出来
        queryWrapper.eq(User::getUserAccount, userAccount).eq(User::getUserPassword, encodePassword);
        User user = this.getOne(queryWrapper);
        if (user == null) {
            log.info("user login failed, userAccount Cannot match userPassword");
        }


        // 3.用户存在 , 进行信息脱敏，隐藏敏感信息，防止数据库中的字段泄露 , 向前端返回脱敏用户信息
        //TODO :就是不返回密码 , 用BeaUtils.copyProperties也可
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setUserAccount(user.getUserAccount());
        newUser.setAvatarUrl(user.getAvatarUrl());
        newUser.setGender(user.getGender());
        newUser.setPhone(user.getPhone());
        newUser.setEmail(user.getEmail());
        newUser.setUserStatus(user.getUserStatus());
        newUser.setCreateTime(user.getCreateTime());

        // 4.记录用户的登录态（session），将其存到服务器上
        request.getSession().setAttribute(UserConstant.USER_LOGIN_STATE, newUser);


        // 5.返回脱敏后的用户信息
        return newUser;
    }


}




