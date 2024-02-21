package com.ozel.minibankingapp.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI api() {
    final String securityScheme = "bearerAuth";
    return new OpenAPI().info(new Info())
        .addServersItem(new Server().url(""))
        .addSecurityItem(new SecurityRequirement().addList(securityScheme)).components(new Components().addSecuritySchemes(securityScheme, new SecurityScheme().name(securityScheme).type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
  }
}