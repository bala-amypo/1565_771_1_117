package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // @Override
    // protected boolean shouldNotFilter(HttpServletRequest request) {
    //     String path = request.getServletPath();
    //     return path.startsWith("/auth")
    //         || path.startsWith("/swagger")
    //         || path.startsWith("/v3/api-docs");
    // }
//     @Override
// protected boolean shouldNotFilter(HttpServletRequest request) {

//     String path = request.getRequestURI();  // ✅ IMPORTANT FIX

//     return path.startsWith("/auth")
//         || path.startsWith("/swagger")
//         || path.startsWith("/v3/api-docs");
// }

@Override
protected boolean shouldNotFilter(HttpServletRequest request) {

    String uri = request.getRequestURI();

    // LOG THIS (TEMPORARY)
    System.out.println("Incoming URI: " + uri);

    return uri.contains("/auth/register")
        || uri.contains("/auth/login")
        || uri.contains("/swagger")
        || uri.contains("/v3/api-docs");
}

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            if (jwtUtil.validateToken(token)) {
                String username = jwtUtil.extractUsername(token);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }
}
