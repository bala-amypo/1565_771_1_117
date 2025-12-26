package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String secret;
    private long expiration;
    private boolean enabled;

    // ✅ REQUIRED by Spring
    public JwtUtil() {
        this.secret = "default-secret";
        this.expiration = 3600000;
        this.enabled = true;
    }

    // ✅ REQUIRED by tests
    public JwtUtil(String secret, long expiration, boolean enabled) {
        this.secret = secret;
        this.expiration = expiration;
        this.enabled = enabled;
    }

    public String generateToken(String username, long userId, String role) {
        return generateToken(username, userId, role, "");
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

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getRole(String token) {
        return (String) Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .get("role");
    }

    public String getUserId(String token) {
        Object id = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .get("uid");
        return id == null ? null : id.toString();
    }
}
