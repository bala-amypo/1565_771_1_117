package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "test-secret-key";
    private final long expiration = 3600000; // 1 hour

    // REQUIRED constructor
    public JwtUtil() {}

    // Required by tests
    public String generateToken(String username, long userId, String role, String extra) {
        return Jwts.builder()
                .setSubject(username)
                .claim("uid", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Used internally
    public String generateToken(String username, Long userId, String role) {
        return generateToken(username, userId, role, "");
    }

    // ✅ REQUIRED BY TEST
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ REQUIRED BY TEST
    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ REQUIRED BY TEST
    public String getRole(String token) {
        return (String) getClaims(token).get("role");
    }

    // ✅ REQUIRED BY TEST
    public Long getUserId(String token) {
        Object id = getClaims(token).get("uid");
        return id == null ? null : Long.parseLong(id.toString());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
