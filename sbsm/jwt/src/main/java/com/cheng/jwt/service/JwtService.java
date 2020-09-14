package com.cheng.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Payload;
import com.cheng.jwt.pojo.PayloadEntity;

import java.util.HashMap;
import java.util.Map;

public class JwtService {

    private String secret= "jwtsecret[`,.']?";
    private String issuer ="service";//发布者
    private String subject ="userLoginToken";//发布者
    private String audience ="APP";//接受签名的

    public PayloadEntity initPayLoad(Map<String,String> claims){
        PayloadEntity payloadEntity=new PayloadEntity();
        payloadEntity.setIssuer(this.issuer);
        payloadEntity.setSubject(this.subject);
        payloadEntity.setAudience(this.audience);
        payloadEntity.setClaims(claims);
        return payloadEntity;
    }

    public String createToken(){

        Algorithm algorithm=Algorithm.HMAC256(this.secret);

        Map<String,Object> map=new HashMap<>();
        map.put("alg",algorithm.getName());
        map.put("typ","JWT");

        //私有声明
        Map<String,String> claimMap=new HashMap<>()

        PayloadEntity init=initPayLoad();

        JWTCreator.Builder builder =JWT.create().withHeader(map);
        if(){

        }
        builder.wi

    }

}
