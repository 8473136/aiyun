import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiuchangLan
 * @date 2020/6/28 17:55
 */
public class JWTest {

    public static void main(String [] args){
        // 设置一个私钥，也可以使用KeyProvider产生，参见：
        // @link https://github.com/auth0/java-jwt#using-a-keyprovider
        String key = "Shenpibaipao";
        // 给定一个算法，如HmacSHA-256
        Algorithm alg = Algorithm.HMAC256(key);

        // 1 签发Token
        Date currentTime = new Date();
        String token = JWT.create()
                .withIssuer("CSDN Blog") // 发行者
                .withSubject("userid") // 用户身份标识
                .withAudience("CSDN User") // 用户单位
                .withIssuedAt(currentTime) // 签发时间
                .withExpiresAt(new Date(currentTime.getTime() + 24*3600*1000L)) // 一天有效期
                .withJWTId("001") // 分配JWT的ID
                .withClaim("PublicClaimExample", "You should not pass!") // 定义公共域信息
                .sign(alg);

        System.out.println("生成的Token是:"+token);

        // 2 验证Token
        JWTVerifier verifier = JWT.require(alg)
                .withIssuer("CSDN Blog")
                .withAudience("CSDN User")
                .build();
        try{
            verifier.verify(token);
            System.out.println("验证通过!");
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            System.out.println("验证失败!");
        }

        // 3 尝试解码
        try{
            DecodedJWT originToken = JWT.decode(token);
            System.out.println("解码得到发行者是:"+originToken.getIssuer());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("解码得到签发时间是:"+sdf.format(originToken.getIssuedAt()));
            System.out.println("解码得到公共域信息是:"+originToken.getClaim("PublicClaimExample").asString());
        } catch (JWTDecodeException e){
            e.printStackTrace();
        }

    }

}
