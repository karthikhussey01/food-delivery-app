package com.karthik.fd.user.service.impl;

import com.karthik.fd.user.config.AppConfig;
import com.karthik.fd.user.model.UserDetail;
import com.karthik.fd.user.service.JwtService;
import com.karthik.fd.user.util.DateUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    private AppConfig config;

    public String generateToken(UserDetail userDetail) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("ROLES", userDetail.getUserProfile().getRole());
        return buildToken(claims, userDetail.getUsername());
    }

    private String buildToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(DateUtil.getCurrentDate())
                .expiration(DateUtil.addMillis(config.getExpirationTime()))
                .signWith(getSigningKey())
                .compact();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(config.getSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
