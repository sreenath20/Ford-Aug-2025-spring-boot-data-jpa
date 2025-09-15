package com.abc.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "My Awesome API",
                version = "1.0",
                description = "This is a comprehensive API for managing various resources."
        )
)
public class ProductappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductappApplication.class, args);
    }

}
