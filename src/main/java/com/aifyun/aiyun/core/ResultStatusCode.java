package com.aifyun.aiyun.core;

import lombok.Getter;

/**
 * @author LiuchangLan
 * @date 2020/6/27 22:02
 */
@Getter
public enum ResultStatusCode {
    /** 正常返回*/
    SUCCESS(200, "OK"),
    SERVER_ERROR(500, "服务器内部错误"),
    LOGIN_NOT(1001, "未登录"),
    PASSWORD_ERROR(1002,"用户名密码不正确");


    private int code;
    private String msg;
    ResultStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
