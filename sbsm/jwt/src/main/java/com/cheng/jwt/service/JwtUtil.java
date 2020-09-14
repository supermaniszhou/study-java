package com.cheng.jwt.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cheng.jwt.pojo.User;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JwtUtil {
    @Test
    public void test(){
        String in="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJsb2dpbm5hbWUiOiJ6aGFuZ3NhbiIsImlzcyI6IlNFUlZJQ0UiLCJleHAiOjE1ODgyMTUwMjYsInVzZXIiOiJleUprWlhCMGJtRnRaU0k2SXVhS2dPYWNyK21EcUNJc0luVnpaWEp1WVcxbElqb2k1YnlnNUxpSkluMD0iLCJpYXQiOjE1ODgyMTQ5OTZ9.OsANGJng6yf376KhzSjksZGvJnIrLpS0al8sGbSACAQ";
        BASE64Encoder base64Encoder=new BASE64Encoder();
        System.out.println(base64Encoder.encode(in.getBytes()));
    }
    @Test
    public void verifyToken() throws IOException {
        String token = createJwttokenByParams();

        Algorithm algorithm = Algorithm.HMAC256("ppppppppppppppppppppppppppppppppp");
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("SERVICE").build();
        DecodedJWT jwt = verifier.verify(token);
        List<String> audience = jwt.getAudience();
        Map<String, Claim> claimMap = jwt.getClaims();
        for (Map.Entry<String, Claim> entry : claimMap.entrySet()) {
            System.out.println(entry.getKey() + "==" + entry.getValue().asString());
        }
        Claim claim=claimMap.get("user");
        String encode=claim.asString();
        BASE64Decoder base64Decoder=new BASE64Decoder();
        String decode=new String(base64Decoder.decodeBuffer(encode));
        User user= JSON.parseObject(decode,new TypeReference<User>(){});
        System.out.println(user.toString());

    }

    /**
     * 生成携带自定义信息 JWT token
     */
//    @Test
    public String createJwttokenByParams() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        User user = new User();
        user.setUsername("张三");
        user.setDeptname("技术部");
        String json = JSON.toJSONString(user);
        BASE64Encoder encoder = new BASE64Encoder();
        String userJson = encoder.encode(json.getBytes());

        Algorithm algorithm = Algorithm.HMAC256("ppppppppppppppppppppppppppppppppp");
        Date date = new Date();
        Date exp = new Date(date.getTime() + 1000 * 30);
        String token = JWT.create()
                .withHeader(map)
                //设置载荷 payload
                .withClaim("loginname", "zhangsan")
                .withClaim("user", userJson)
                .withIssuer("SERVICE")
                .withAudience("APP")
                .withExpiresAt(exp)
                .withIssuedAt(date)
                .sign(algorithm);
        System.out.println(token);
        return token;
    }

    /**
     * 生成不携带自定义信息 JWT token
     */
    //    @Test
    public void createJwtToken() {
        //构建头部信息
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        //构建密钥信息
        Algorithm algorithm = Algorithm.HMAC256("secret");
        Date date = new Date();
        long exp = date.getTime() + 1000 * 30;

        String token = JWT.create()
                .withHeader(map)//设置头部信息
                .withIssuer("SERVICE")////设置 载荷 签名是有谁生成 例如 服务器
                .withSubject("this is test token")//设置 载荷 签名的主题
                .withAudience("APP")//设置 载荷 签名的观众 也可以理解谁接受签名的
                .withIssuedAt(date)//设置 载荷 生成签名的时间
                .withExpiresAt(new Date(exp))//设置 载荷 签名过期的时间
                .sign(algorithm);//签名 Signature
        System.out.println(token);
//        assert (token.length() > 0);
    }


}
