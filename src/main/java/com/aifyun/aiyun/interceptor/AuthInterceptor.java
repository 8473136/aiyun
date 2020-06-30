package com.aifyun.aiyun.interceptor;

import com.aifyun.aiyun.core.BusinessException;
import com.aifyun.aiyun.core.Result;
import com.aifyun.aiyun.core.ResultStatusCode;
import com.aifyun.aiyun.utils.TokenUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author LiuchangLan
 * @date 2020/6/30 11:02
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getCookies() == null){
            throw new BusinessException(ResultStatusCode.LOGIN_NOT);
        }else {
            for (Cookie cookie : request.getCookies()) {
                if ("accessToken".equals(cookie.getName())) {
                    if (TokenUtils.verifier(cookie.getValue())) {
                        //验证成功
                        log.info("用户已登录");
                        cookie.setValue(TokenUtils.getToken(TokenUtils.decrypt(cookie.getValue())));
                        return true;
                    } else {
                        //验证失败
                        log.debug("用户未登录");
                        throw new BusinessException(ResultStatusCode.LOGIN_NOT);
                    }
                }
            }
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
