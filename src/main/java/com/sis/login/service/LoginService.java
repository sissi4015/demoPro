package com.sis.login.service;

/**
 * @ClassName: LoginService
 * @Description: TODO
 * @Author: Sissi
 * @Date: 2022/3/31 13:04
 * @Version: 1.0
 */
public class LoginService {

    //#TODO 连接数据库
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "root";

    public boolean login(String userName, String userPassword){

        if(DEFAULT_USER.equals(userName) && DEFAULT_PASSWORD.equals(userName)){
            return true;
        }

        return false;

    }

}
