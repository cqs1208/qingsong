package com.qingsong.util;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenqingsong
 * @date : 2019-09-19 16:52
 */
@Component
public class JwtUtil {

    public static final long EXPIRATION_TIME = 1000000; //
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static String generateToken(String username,Date generateTime) {
        HashMap<String, Object> map = new HashMap<>();
        //可以把任何安全的数据放到map里面
        map.put("username", username);
        map.put("generateTime",generateTime);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(generateTime.getTime() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return jwt;
    }

    /**
     * @param token
     * @return
     */
    public static Map<String,Object> validateToken(String token) {
        Map<String,Object> resp = new HashMap<String,Object>();
        if (token != null) {
            // 解析token
            try {
                Map<String, Object> body = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody();
                String username = (String) (body.get("username"));
                Date generateTime = new Date((Long)body.get("generateTime"));

                if(username == null || username.isEmpty()){
                    resp.put("ERR_MSG",Constants.ERR_MSG_USERNAME_EMPTY);
                    return resp;
                }
                resp.put("username",username);
                resp.put("generateTime",generateTime);
                return resp;
            }catch (ExpiredJwtException e) {
                // TODO: handle exception
                // jwt 已经过期，在设置jwt的时候如果设置了过期时间，这里会自动判断jwt是否已经过期，如果过期则会抛出这个异常，我们可以抓住这个异常并作相关处理。
                resp.put("ERR_MSG",Constants.ERR_MSG_TOKEN_EXP);
                return resp;
            }catch (Exception e) {
                // TODO: handle exception
                // don't trust the JWT!
                // jwt 解析错误
                resp.put("ERR_MSG",Constants.ERR_MSG_TOKEN_ERR);
                return resp;
            }
        }else {
            resp.put("ERR_MSG",Constants.ERR_MSG_TOKEN_EMPTY);
            return resp;
        }
    }
}
