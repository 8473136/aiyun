package com.aifyun.aiyun.utils;

import com.aifyun.aiyun.dto.UserDTO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.StyledEditorKit;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiuchangLan
 * @date 2020/6/29 15:45
 */
@Slf4j
public class TokenUtils {
    public static final String TOKEN_SECRET = "A5D833ABE7685BA6AB2E30BD8156E6E";

    /**
     * @description 生成token
     * @author LiuChangLan
     * @since 2020/6/29 15:53
     */
    public static String getToken(UserDTO userDTO){
        Algorithm alg = Algorithm.HMAC256(TOKEN_SECRET);
        Date currentTime = new Date();
        String token = JWT.create()
                // 发行者
                .withIssuer("ai_yun_system")
                // 用户身份标识
                .withSubject(userDTO.getId())
                // 用户单位
                .withAudience("ai_yun_system")
                // 签发时间
                .withIssuedAt(currentTime)
                // 一天有效期
                .withExpiresAt(new Date(currentTime.getTime() + 24*3600*1000L))
                // 分配JWT的ID
                .withJWTId(UUIDUtils.getUUID())
                // 定义公共域信息
                .withClaim("loginUser", JSON.toJSONString(userDTO))
                // 加密的密钥
                .sign(alg);
        log.info(String.format("给用户%s生成token%s",userDTO.getId(),token));
       return token;
    }


    /**
     * @description 验证token
     * @author LiuChangLan
     * @since 2020/6/29 15:53
     */
    public static boolean verifier(String token){
        Algorithm alg = Algorithm.HMAC256(TOKEN_SECRET);
        // 2 验证Token
        JWTVerifier verifier = JWT.require(alg)
                .withIssuer("ai_yun_system")
                .withAudience("ai_yun_system")
                .build();
        try{
            verifier.verify(token);
            log.info("token验证成功!");
            return true;
        } catch (JWTVerificationException e) {
            log.debug("token验证失败!");
            return false;
        }
    }

    /**
     * @description 获取token的内容
     * @author LiuChangLan
     * @since 2020/6/29 15:57
     */
    public static UserDTO decrypt(String token){
        DecodedJWT originToken = JWT.decode(token);
        log.info("解码得到发行者是:"+originToken.getIssuer());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(String.format("token签发时间%s",DateUtils.yMdHmsFormat(originToken.getIssuedAt())));
        String publicClaimExample = originToken.getClaim("loginUser").asString();
        UserDTO userDTO = JSON.parseObject(publicClaimExample, UserDTO.class);
        return userDTO;
    }
}
