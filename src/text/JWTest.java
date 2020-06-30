import com.aifyun.aiyun.utils.TokenUtils;
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
        String token = "aeyJ0eXAiOiJKV1QiLCJhbGciOiJIUzIasdf1NiJ9.eyJzdWIiOiI5ZmQwZTM2ZGYxOTI0ZDc5YWU5YTRjMmY1MGExNzk5ZSIsImF1ZCI6ImFpX3l1bl9zeXN0ZW0iLCJsb2dpblVzZXIiOiJ7XCJhdmF0YXJcIjpcImh0dHBzOi8vaW1nMi53b3lhb2dleGluZy5jb20vMjAyMC8wNi8yOC84ODlmMzI4M2I5ZDQ0OWUzYmQzNGY2NDU3NDhmZDVhOSE0MDB4NDAwLmpwZWdcIixcImNyZWF0ZWRUaW1lXCI6XCIyMDIwLTA2LTI4IDEwOjQzOjQ3XCIsXCJlbWFpbFwiOlwiODQ3MzEzNkBxcS5jb21cIixcImlkXCI6XCI5ZmQwZTM2ZGYxOTI0ZDc5YWU5YTRjMmY1MGExNzk5ZVwiLFwiaXNEZWxldGVlZFwiOjAsXCJzYWx0XCI6XCIwMjEyN2EwN2U1MzQ0Nzg4YTYxZTBmNTMxZDQxMjM1NlwiLFwidXBkYXRlZFRpbWVcIjpcIjIwMjAtMDYtMjggMTA6NDM6NDdcIixcInVzZXJHcm91cHNcIjpcImU2MWFlMjZlYTdkYzRjNmY4YTZhNTMzODhhOGVlMDlkXCIsXCJ1c2VyUGFzc3dvcmRcIjpcIjJCNzU2MTBFMDRENzk3M0VCRjBGRThBRkVDQTkzMzAxXCJ9IiwiaXNzIjoiYWlfeXVuX3N5c3RlbSIsImV4cCI6MTU5MzQxODE4OCwiaWF0IjoxNTkzNDE4MTg3LCJqdGkiOiI2MTQ2NmMzZDY3YTE0MjEwYTEyZmZlMTM1MTg4NjdhYyJ9.lMhr7EHS3x5tW-y8B1Bex_uqgvXaZhEwD0pugEM4CjY";
        System.out.println(TokenUtils.verifier(token));

    }

}
