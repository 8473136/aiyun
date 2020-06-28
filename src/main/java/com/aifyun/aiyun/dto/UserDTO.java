package com.aifyun.aiyun.dto;

import com.aifyun.aiyun.core.BaseDTO;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author LiuchangLan
 * @date 2020/6/27 23:15
 */
@Data
@Table(name = "aiyun_users")
public class UserDTO extends BaseDTO {
    // 头像
    private String avatar;

    // 邮箱
    private String email;

    // 手机号
    private String phone;

    // 盐
    private String salt;

    // 用户组
    private String userGroups;

    // 昵称
    private String userNickName;

    // 用户密码
    private String userPassword;

}
