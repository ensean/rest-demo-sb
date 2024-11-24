package com.rest.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Sample REST Microservices", version = "1.0", description = "REST API methods to operate on Users and Teachers"))
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(
                        new Info()
                                .title("Sample Microservices")
                                .description("Sample Microservices")
                                .version("1.0"));
    }

    @Bean
    public GroupedOpenApi openApiAll() {
        String[] packagesToscan = {"com.rest.example.controller"};
        return GroupedOpenApi.builder()
                .group("All Services")
                .packagesToScan(packagesToscan)
                .build();
    }
}
