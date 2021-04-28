package com.knowonespace.longblack.utils;

import com.knowonespace.longblack.common.Constant;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");//得到MD5加密工具
        byte[] digest = md5.digest((strValue+ Constant.SALT).getBytes());//加上盐值，因为接收的类型是Bytes，得到加密
        String str = Base64.encodeBase64String(digest);//将得到的加密字符进行64位的转码方便存储
        return str;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String dqwd = MD5Utils.getMD5Str("12345678");
        System.out.println(dqwd);
    }
}
