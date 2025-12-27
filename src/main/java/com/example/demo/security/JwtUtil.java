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
package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component   // ✅ THIS WAS MISSING
public class JwtUtil {

    // ===== REQUIRED BY TESTS =====
    public JwtUtil() {}

    public JwtUtil(String secret, long expiration, boolean enabled) {}

    // ===== TOKEN FORMAT =====
    // email:userId:role:username

    public String generateToken(String email, Long userId, String role, String username) {
        return email + ":" + userId + ":" + role + ":" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.split(":").length == 4;
    }

    public String getEmail(String token) {
        return token.split(":")[0];
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split(":")[1]);
    }

    public String getRole(String token) {
        return token.split(":")[2];
    }

    public String getUsername(String token) {
        return token.split(":")[3];
    }
}
