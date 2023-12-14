package com.lanyx.model;

import lombok.Data;

import java.io.Serializable;


@Data  //得到所有属性得 get set 方法
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 5919345224095313040L;
    private String userAccount;
    private String userPassword;
}
