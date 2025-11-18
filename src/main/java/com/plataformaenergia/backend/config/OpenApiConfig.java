package com.plataformaenergia.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Plataforma de Intercambio de Energía Solar - API")
                .version("1.0.0")
                .description("Documentación de la API backend del proyecto de intercambio de energía solar")
            );
    }
}
