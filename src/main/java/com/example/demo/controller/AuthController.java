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

import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService service;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest request) {
        return service.createUser(request);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        UserAccount user = service.authenticate(request);
        String token = jwtUtil.generateToken(user.getUsername());
        return new JwtResponse(token);
    }
}
