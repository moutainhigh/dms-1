package com.bzdgs.dms.tool;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {
    //加密方式
    private static final String ALGORITHMNAME = "MD5";
    //盐值
    private static final String SALT = "cn.itsource";
    //加密次数
    private static final Integer HASHITERATIONS = 10;

    public static String getMD5Password(String password){
        SimpleHash simpleHash = new SimpleHash(ALGORITHMNAME, password, SALT, HASHITERATIONS);
        return simpleHash.toString();
    }

}
