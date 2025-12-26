package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String secret;
    private final long expiration;
    private final boolean enabled;

    public JwtUtil(String secret, long expiration, boolean enabled) {
        this.secret = secret;
        this.expiration = expiration;
        this.enabled = enabled;
    }

    public JwtUtil() {
        this.secret = "default-secret";
        this.expiration = 3600000;
        this.enabled = true;
    }

    public String generateToken(String username, long userId, String role, String extra) {
        return Jwts.builder()
                .setSubject(username)
                .claim("uid", userId)
                .claim("role", role)
                .claim("extra", extra)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String generateToken(String username, Long userId, String role) {
        return generateToken(username, userId, role, "");
    }

    public String getEmail(String token) {
        return (String) Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Long getUserId(String token) {
        return ((Number) Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .get("uid")).longValue();
    }

    public String getRole(String token) {
        return (String) Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .get("role");
    }
}
