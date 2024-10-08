package com.app.enh_webapp;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "ENH Web-Demo App",
                version = "1.0",
                description = "API Documentation",
                contact = @Contact(
                        name = "ENHiSecure",
                        url = "https://www.enhisecure.com/",
                        email = "isecure@enhisecure.com"
                )
        ),
        security = {
                @SecurityRequirement(
                        name = "Basic Auth"
                )
        },
        servers = {
                @Server(url = "https://localhost:8080")
        }
)

@SpringBootApplication
public class EnhWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnhWebAppApplication.class, args);
    }

}
