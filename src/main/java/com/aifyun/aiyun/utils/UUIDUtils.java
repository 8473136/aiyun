package com.aifyun.aiyun.utils;

import com.aifyun.aiyun.core.BaseDTO;
import com.aifyun.aiyun.dto.UserDTO;

import java.util.UUID;

/**
 * uuid工具
 * @author LiuchangLan
 * @date 2020/6/27 22:59
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        System.out.println(userDTO.getId());
        System.out.println(userDTO.getCreateTime());
        System.out.println(userDTO.getUpdateTime());
    }
}
