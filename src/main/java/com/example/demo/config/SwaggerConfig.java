// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.servers.Server;
// import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.util.List;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {

//         return new OpenAPI()
//                 .info(new Info()
//                         .title("IT Policy Management API")
//                         .version("1.0")
//                         .description("Swagger documentation for IT Policy Violation System"))
                
//                 // 🔹 SERVER CONFIGURATION
//                 .servers(List.of(
//                         new Server()
//                                 .url("https://9089.pro604cr.amypo.ai")
//                                 .description("Local Development Server")
//                 ))

//                 // 🔐 JWT SECURITY
//                 .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
//                 .components(
//                         new io.swagger.v3.oas.models.Components()
//                                 .addSecuritySchemes("BearerAuth",
//                                         new SecurityScheme()
//                                                 .type(SecurityScheme.Type.HTTP)
//                                                 .scheme("bearer")
//                                                 .bearerFormat("JWT")
//                                 )
//                 );
//     }
// }
package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        final String securitySchemeName = "BearerAuth";

        return new OpenAPI()
                .info(
                        new Info()
                                .title("IT Policy Management API")
                                .version("1.0")
                                .description("Swagger documentation for IT Policy Management System")
                )
                .servers(List.of(
                        new Server()
                                .url("https://9089.pro604cr.amypo.ai")
                                .description("Production Server")
                ))
                .addSecurityItem(
                        new SecurityRequirement().addList(securitySchemeName)
                )
                .components(
                        new io.swagger.v3.oas.models.Components()
                                .addSecuritySchemes(
                                        securitySchemeName,
                                        new SecurityScheme()
                                                .name("Authorization")
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}
