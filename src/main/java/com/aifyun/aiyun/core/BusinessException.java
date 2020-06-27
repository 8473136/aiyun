package com.aifyun.aiyun.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 业务异常
 * @author LiuchangLan
 * @date 2020/6/27 22:23
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class BusinessException extends Exception{
    private Integer errorCode;
    private String errorMsg;

    public BusinessException(ResultStatusCode resultStatusCode){
        this.errorCode = resultStatusCode.getCode();
        this.errorMsg =resultStatusCode.getMsg();
    }
}
