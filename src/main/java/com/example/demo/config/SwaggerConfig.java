package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
            // 🔒 DEFAULT SECURITY (LOCK)
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(
                new io.swagger.v3.oas.models.Components()
                    .addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                            .name("Authorization")
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                            .servers(List.of(
                new Server().url("https://9089.pro604cr.amypo.ai")
            ))
                    )
            );
    }
}
