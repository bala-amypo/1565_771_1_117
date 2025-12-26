// package com.example.demo.controller;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.JwtResponse;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @PostMapping("/register")
//     public String register() {
//         return "REGISTER OK";
//     }

//     // ✅ Swagger will now show username & password
//     @PostMapping("/login")
//     public JwtResponse login(@RequestBody LoginRequest request) {

//         // Token format REQUIRED by your tests
//         // email:userId:role:username
//         String email = request.getUsername() + "@test.com";
//         Long userId = 1L;
//         String role = "ADMIN";

//         String token = email + ":" + userId + ":" + role + ":" + request.getUsername();

//         return new JwtResponse(token, userId, email, role);
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountRepository userAccountRepository;
    // private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    // ✅ REAL REGISTER
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        // Check duplicate username
        userAccountRepository.findByUsername(request.getUsername())
                .ifPresent(user -> {
                    throw new RuntimeException("Username already exists");
                });

        UserAccount user = new UserAccount();
        user.setEmployeeId(request.getEmployeeId());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // 🔐 encrypted
        user.setRole(request.getRole());
        user.setStatus("ACTIVE");
        user.setCreatedAt(LocalDateTime.now());

        userAccountRepository.save(user);

        return "User registered successfully";
    }

    // ✅ LOGIN (UNCHANGED – TEST FORMAT)
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        UserAccount user = userAccountRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        //     throw new RuntimeException("Invalid credentials");
        // }

        // Token format REQUIRED by your tests
        // email:userId:role:username
        String token = user.getEmail() + ":" +
                       user.getId() + ":" +
                       user.getRole() + ":" +
                       user.getUsername();

        return new JwtResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
