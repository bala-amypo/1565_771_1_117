package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        SecurityScheme bearerScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        OpenAPI openAPI = new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", bearerScheme))
                // 🔒 Global JWT security
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));

        // ❌ REMOVE LOCK FROM /auth/**
        Paths paths = openAPI.getPaths();
        if (paths != null) {
            paths.forEach((path, item) -> {
                if (path.startsWith("/auth")) {
                    item.readOperations()
                        .forEach(op -> op.setSecurity(null));
                }
            });
        }

        return openAPI;
    }
}
