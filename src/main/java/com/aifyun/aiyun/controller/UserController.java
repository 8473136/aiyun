package com.aifyun.aiyun.controller;

import com.aifyun.aiyun.core.BusinessException;
import com.aifyun.aiyun.service.UserService;
import com.aifyun.aiyun.vo.UserRegisteredVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author LiuchangLan
 * @date 2020/6/27 22:56
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * @description 用户注册
     * @author LiuChangLan
     * @since 2020/6/28 15:21
     */
    @PostMapping("registered")
    public void registered(@RequestBody UserRegisteredVO userRegisteredVO) {
        userService.registered(userRegisteredVO);
    }

    @PostMapping("login")
    public String login(@RequestBody UserRegisteredVO userRegisteredVO) throws BusinessException {
        return userService.login(userRegisteredVO);
    }

    @PostMapping("refreshToken")
    public String refreshToken(@RequestParam String token){
        return userService.refreshToken(token);
    }



}
