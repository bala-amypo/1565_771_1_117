// // package com.example.demo.security;

// // public class JwtUtil {

// //     private String secret;
// //     private long expiry;
// //     private boolean enabled;

    
// //     public JwtUtil() {
// //     }

// //     public JwtUtil(String secret, long expiry, boolean enabled) {
// //         this.secret = secret;
// //         this.expiry = expiry;
// //         this.enabled = enabled;
// //     }

// //     public String generateToken(String username, Long userId, String email, String role) {
// //         return username + ":" + userId + ":" + email + ":" + role;
// //     }

// //     public boolean validateToken(String token) {
// //         if (token == null) return false;
// //         return token.split(":").length == 4;
// //     }

// //     public String getEmail(String token) {
// //         return token.split(":")[2];
// //     }

// //     public Long getUserId(String token) {
// //         return Long.parseLong(token.split(":")[1]);
// //     }

// //     public String getRole(String token) {
// //         return token.split(":")[3];
// //     }
// // }
// package com.example.demo.security;

// import org.springframework.stereotype.Component;

// @Component   // ✅ THIS WAS MISSING
// public class JwtUtil {

//     // ===== REQUIRED BY TESTS =====
//     public JwtUtil() {}

//     public JwtUtil(String secret, long expiration, boolean enabled) {}

//     // ===== TOKEN FORMAT =====
//     // email:userId:role:username

//     public String generateToken(String email, Long userId, String role, String username) {
//         return email + ":" + userId + ":" + role + ":" + username;
//     }

//     public boolean validateToken(String token) {
//         return token != null && token.split(":").length == 4;
//     }

//     public String getEmail(String token) {
//         return token.split(":")[0];
//     }

//     public Long getUserId(String token) {
//         return Long.parseLong(token.split(":")[1]);
//     }

//     public String getRole(String token) {
//         return token.split(":")[2];
//     }

//     public String getUsername(String token) {
//         return token.split(":")[3];
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Generates a secure JWT with custom claims.
     * Matches the signature: (String email, Long userId, String role, String username)
     */
    public String generateToken(String email, Long userId, String role, String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("email", email);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private SecretKey getSignKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Example helper to extract claims if needed for filters
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}