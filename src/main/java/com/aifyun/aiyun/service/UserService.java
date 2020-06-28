package com.aifyun.aiyun.service;

import com.aifyun.aiyun.core.BusinessException;
import com.aifyun.aiyun.vo.UserRegisteredVO;

public interface UserService {
    void registered(UserRegisteredVO userRegisteredVO);

    String login(UserRegisteredVO userRegisteredVO) throws BusinessException;
}
