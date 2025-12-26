package com.example.demo.security;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Component   // 🔥 THIS IS THE FIX
public class JwtUtil {

    private final String secret = "my-secret-key";
    private final long expiration = 3600000;

    public JwtUtil() {
    }

    public String generateToken(String username, long userId, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("uid", userId)
                .claim("role", role)
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
                .parseClaimsJws(token)
                .getBody()
                .get("role");
    }
}
