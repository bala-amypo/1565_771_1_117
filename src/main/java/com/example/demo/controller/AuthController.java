// package com.example.demo.controller;

// import com.example.demo.dto.JwtResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.UserAccount;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserAccountService;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserAccountService userService;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/register")
//     public JwtResponse register(@RequestBody RegisterRequest request) {

//         UserAccount user = new UserAccount();
//         user.setUsername(request.getUsername());
//         user.setEmail(request.getEmail());
//         user.setPassword(request.getPassword());
//         user.setRole(request.getRole());
//         user.setEmployeeId(request.getEmployeeId());

//         UserAccount saved = userService.createUser(user);

//         String token = jwtUtil.generateToken(
//                 saved.getUsername(),
//                 saved.getId(),
//                 saved.getRole()
//         );

//         return new JwtResponse(token, saved.getId(), saved.getEmail(), saved.getRole());
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setEmployeeId(request.getEmployeeId());

        UserAccount saved = userService.createUser(user);
        return ResponseEntity.ok(saved);
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        // 🔹 Login by username (NOT userId)
        UserAccount user = userService.getUserById(
                Long.parseLong(request.getUsername())
        );

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        // 🔹 JWT creation (matches constructor exactly)
        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getId(),
                user.getRole(),
                user.getUsername()
        );

        return ResponseEntity.ok(
                new JwtResponse(
                        token,
                        user.getId(),
                        user.getRole(),
                        user.getUsername()
                )
        );
    }
}
