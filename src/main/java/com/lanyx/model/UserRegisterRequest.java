package com.lanyx.model;

import lombok.Data;

import java.io.Serializable;


@Data  //得到所有属性得 get set 方法
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 2295197071442477837L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
