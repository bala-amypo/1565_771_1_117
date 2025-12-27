package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey key;
    private final long expiration;
    private final boolean enabled;

    // ✅ Default constructor for Spring
    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor("default-secret-default-secret-123456".getBytes(StandardCharsets.UTF_8));
        this.expiration = 3600000;
        this.enabled = true;
    }

    // ✅ Constructor used by tests
    public JwtUtil(String secret, long expiration, boolean enabled) {
        if (secret == null || secret.length() < 32) {
            secret = (secret == null ? "" : secret);
            secret = String.format("%-32s", secret).replace(' ', 'x'); // pad to 32 chars
        }
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
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
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getRole(String token) {
        return (String) Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role");
    }

    public String getUserId(String token) {
        Object id = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("uid");
        return id == null ? null : id.toString();
    }
}
