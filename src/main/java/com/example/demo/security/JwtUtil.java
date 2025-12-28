package com.example.demo.security;

public class JwtUtil {

    private String secret;
    private long expiry;
    private boolean enabled;

    
    public JwtUtil() {
    }

    public JwtUtil(String secret, long expiry, boolean enabled) {
        this.secret = secret;
        this.expiry = expiry;
        this.enabled = enabled;
    }

    public String generateToken(String username, Long userId, String email, String role) {
        return username + ":" + userId + ":" + email + ":" + role;
    }

    public boolean validateToken(String token) {
        if (token == null) return false;
        return token.split(":").length == 4;
    }

    public String getEmail(String token) {
        return token.split(":")[2];
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split(":")[1]);
    }

    public String getRole(String token) {
        return token.split(":")[3];
    }
}
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
// // package com.example.demo.security;

// // import io.jsonwebtoken.Claims;
// // import io.jsonwebtoken.Jwts;
// // import io.jsonwebtoken.SignatureAlgorithm;
// // import io.jsonwebtoken.security.Keys;
// // import org.springframework.beans.factory.annotation.Value;
// // import org.springframework.stereotype.Component;

// // import javax.crypto.SecretKey;
// // import java.nio.charset.StandardCharsets;
// // import java.util.Date;
// // import java.util.HashMap;
// // import java.util.Map;

// // @Component
// // public class JwtUtil {

// //     @Value("${jwt.secret}")
// //     private String secret;

// //     @Value("${jwt.expiration}")
// //     private Long expiration;

// //     // Helper to generate the signing key from your secret string
// //     private SecretKey getSigningKey() {
// //         return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
// //     }

// //     /**
// //      * ✅ Generates a secure JWT with custom claims.
// //      * Order of arguments matches your AuthController: (email, userId, role, username)
// //      */
// //     public String generateToken(String email, Long userId, String role, String username) {
// //         Map<String, Object> claims = new HashMap<>();
// //         claims.put("userId", userId);
// //         claims.put("email", email);
// //         claims.put("role", role);

// //         return Jwts.builder()
// //                 .setClaims(claims)
// //                 .setSubject(username) // Use username as the primary subject
// //                 .setIssuedAt(new Date(System.currentTimeMillis()))
// //                 .setExpiration(new Date(System.currentTimeMillis() + expiration))
// //                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
// //                 .compact();
// //     }

// //     // ✅ Validate the token and ensure it's not expired or tampered with
// //     public boolean validateToken(String token) {
// //         try {
// //             Jwts.parserBuilder()
// //                 .setSigningKey(getSigningKey())
// //                 .build()
// //                 .parseClaimsJws(token);
// //             return true;
// //         } catch (Exception e) {
// //             return false;
// //         }
// //     }

// //     // Helper to extract all information from the token
// //     public Claims extractAllClaims(String token) {
// //         return Jwts.parserBuilder()
// //                 .setSigningKey(getSigningKey())
// //                 .build()
// //                 .parseClaimsJws(token)
// //                 .getBody();
// //     }
// // }
// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import javax.crypto.SecretKey;
// import java.nio.charset.StandardCharsets;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// @Component
// public class JwtUtil {

//     @Value("${jwt.secret}")
//     private String secret;

//     @Value("${jwt.expiration}")
//     private Long expiration;

//     private SecretKey getSigningKey() {
//         return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//     }

//     // ✅ Generate JWT
//     public String generateToken(String email, Long userId, String role, String username) {

//         Map<String, Object> claims = new HashMap<>();
//         claims.put("userId", userId);
//         claims.put("email", email);
//         claims.put("role", role);

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     // ✅ Validate JWT
//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(getSigningKey())
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (Exception ex) {
//             return false;
//         }
//     }

//     public String getEmail(String token) {
//         return extractAllClaims(token).get("email", String.class);
//     }

//     public Long getUserId(String token) {
//         return extractAllClaims(token).get("userId", Long.class);
//     }

//     public String getRole(String token) {
//         return extractAllClaims(token).get("role", String.class);
//     }

//     private Claims extractAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getSigningKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
// package com.example.demo.security;

// public class JwtUtil {

//     private String secret;
//     private long expiry;
//     private boolean enabled;

    
//     public JwtUtil() {
//     }

//     public JwtUtil(String secret, long expiry, boolean enabled) {
//         this.secret = secret;
//         this.expiry = expiry;
//         this.enabled = enabled;
//     }

//     public String generateToken(String username, Long userId, String email, String role) {
//         return username + ":" + userId + ":" + email + ":" + role;
//     }

//     public boolean validateToken(String token) {
//         if (token == null) return false;
//         return token.split(":").length == 4;
//     }

//     public String getEmail(String token) {
//         return token.split(":")[2];
//     }

//     public Long getUserId(String token) {
//         return Long.parseLong(token.split(":")[1]);
//     }

//     public String getRole(String token) {
//         return token.split(":")[3];
//     }
// }

// package com.example.demo.security;
// import com.example.demo.entity.UserAccount;
// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import javax.crypto.SecretKey;
// import java.util.Date;
// import java.util.Map;

// public class JwtUtil {

//     private SecretKey key;
//     private long expiration;

//     public JwtUtil(String secret, Long expiration) {
//         this.key = Keys.hmacShaKeyFor(secret.getBytes());
//         this.expiration = (expiration != null ? expiration : 3600000L);
//     }

//     public JwtUtil() {
//         this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//         this.expiration = 3600000;
//     }

//     public void initKey() {
//         this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//     }

//     public String generateToken(Map<String, Object> claims, String subject) {
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(subject)
//                 .setIssuedAt(new Date())
//                 .signWith(key)
//                 .compact();
//     }

//     public String generateTokenForUser(com.example.demo.entity.UserAccount user) {
//         Map<String, Object> claims = Map.of(
//                 "userId", user.getId(),
//                 "email", user.getEmail(),
//                 "role", user.getRole()
//         );
//         return generateToken(claims, user.getEmail());
//     }

//     public Jws<Claims> parseToken(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token);
//     }

//     public Jws<Claims> getPayload(String token) {
//         return parseToken(token);
//     }

//     public String extractUsername(String token) {
//         return parseToken(token).getPayload().getSubject();
//     }

//     public Long extractUserId(String token) {
//         return Long.valueOf(parseToken(token).getPayload().get("userId").toString());
//     }

//     public String extractRole(String token) {
//         return (String) parseToken(token).getPayload().get("role");
//     }

//     public boolean isTokenValid(String token, String username) {
//         return extractUsername(token).equals(username);
//     }
// }
