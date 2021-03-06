package com.aifyun.aiyun.utils;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * MD5加密
 * @author LiuchangLan
 * @date 2020/6/28 15:34
 */
public class MD5Utils {

    public static String MD5(String source){
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(source.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryption(String password,String salt){
        return MD5(password + salt);
    }

    public static boolean verification(String inputPassword,String salt,String password){
        return encryption(inputPassword,salt).equals(password);
    }

}
