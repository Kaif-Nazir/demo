package com.example.freelancing.demo.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI itemApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Item API")
                        .description("Simple REST API for managing items")
                        .version("1.0.0"));
    }
}
