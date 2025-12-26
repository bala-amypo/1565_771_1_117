// package com.example.demo.security;

// import jakarta.servlet.*;
// import jakarta.servlet.http.*;
// import java.io.IOException;

// public class JwtAuthenticationFilter implements Filter {

//     JwtUtil jwtUtil;

//     public JwtAuthenticationFilter(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @Override
//     public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//             throws IOException, ServletException {

//         HttpServletRequest request = (HttpServletRequest) req;
//         String header = request.getHeader("Authorization");

//         if (header != null && header.startsWith("Bearer ")) {
//             String token = header.substring(7);
//             jwtUtil.validateToken(token);
//         }

//         chain.doFilter(req, res);
//     }
// }
