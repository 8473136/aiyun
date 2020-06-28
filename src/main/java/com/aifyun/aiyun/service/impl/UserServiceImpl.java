package com.aifyun.aiyun.service.impl;

import com.aifyun.aiyun.common.GlobalVariables;
import com.aifyun.aiyun.core.BusinessException;
import com.aifyun.aiyun.core.Result;
import com.aifyun.aiyun.core.ResultStatusCode;
import com.aifyun.aiyun.dto.UserDTO;
import com.aifyun.aiyun.mapper.UserMapper;
import com.aifyun.aiyun.service.UserService;
import com.aifyun.aiyun.utils.DateUtils;
import com.aifyun.aiyun.utils.MD5Utils;
import com.aifyun.aiyun.utils.UUIDUtils;
import com.aifyun.aiyun.vo.UserRegisteredVO;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author LiuchangLan
 * @date 2020/6/28 14:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * @description 登录
     * @author LiuChangLan
     * @since 2020/6/28 18:59
     * @param userRegisteredVO 登录参数
     */
    @Override
    public String login(UserRegisteredVO userRegisteredVO) throws BusinessException {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(userRegisteredVO.getEmail());
        userDTO.setIsDeleteed(0);
        userDTO = userMapper.selectOne(userDTO);



        // 用户名密码不正确
        if (userDTO == null || !MD5Utils.verification(userRegisteredVO.getPassword(),userDTO.getSalt(),userDTO.getUserPassword())){
            throw new BusinessException(ResultStatusCode.PASSWORD_ERROR);
        }


        return null;
    }

    /**
     * @description 注册
     * @author LiuChangLan
     * @since 2020/6/28 18:59
     * @param userRegisteredVO 注册参数
     */
    @Override
    public void registered(UserRegisteredVO userRegisteredVO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(UUIDUtils.getUUID());
        userDTO.setEmail(userRegisteredVO.getEmail());
        userDTO.setSalt(UUIDUtils.getUUID());
        userDTO.setUserPassword(MD5Utils.encryption(userRegisteredVO.getPassword(),userDTO.getSalt()));
        userDTO.setAvatar(GlobalVariables.DEFAULT_avatar_URL);
        userDTO.setUserGroups(GlobalVariables.DEFAULT_USER_GROUB_ID);
        userMapper.insertSelective(userDTO);
    }
}
