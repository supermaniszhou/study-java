package com.cheng.jwt.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class PayloadEntity {
    private String issuer;//发布者
    private String subject;//主题
    private String audience;
    private Date issuedAt;//发布时间
    private Date expiresAt;//过期时间
    private Map<String,String> claims;
}
