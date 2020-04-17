package com.example.dormitory.utils;

import io.jsonwebtoken.*;

import java.util.Date;

public class JwtTokenUtil {
    private static final String KEY = "space";
    private static final long EXPIRATION = 30 * 60 * 1000;
    private Claims claims;

    public JwtTokenUtil(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        claims = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public static String createToken(String username, String authorities) {
        return Jwts.builder()
                .claim("authorities", authorities)
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, KEY)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .compact();
    }

    public String getUsername() {
        return claims.getSubject();
    }

    public String getAuthorities() {
        return (String) claims.get("authorities");
    }

    public boolean isExpired() {
        return claims.getExpiration().after(new Date());
    }
}
