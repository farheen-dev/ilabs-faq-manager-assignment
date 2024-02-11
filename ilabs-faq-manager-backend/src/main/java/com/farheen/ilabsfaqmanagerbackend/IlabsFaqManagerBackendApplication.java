package com.farheen.ilabsfaqmanagerbackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title="iLabs - Faq Manager APIs",
                version = "1.0.0",
                description = "API documentation of iLabs - Faq Manager Assignment",
                contact = @Contact(
                        name = "Farheen Boosary",
                        email = "dev.farheen.se@gmail.com"
                )
        )
)
public class IlabsFaqManagerBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(IlabsFaqManagerBackendApplication.class, args);
    }
}
