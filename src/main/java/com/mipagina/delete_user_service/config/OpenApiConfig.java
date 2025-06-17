package com.mipagina.delete_user_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Delete User Service API")
                        .version("1.0.0")
                        .description(
                                "This API handles user deletion by ID and ensures associated role assignments are also removed from the related Role Assignment Service.\n\n" +
                                        "**Important:** When deleting a user, both the user record in the MySQL database and the linked roles in the Role Assignment Service (MariaDB) are deleted.\n" +
                                        "If the user ID does not exist, the API returns a 404 Not Found error.\n" +
                                        "If deletion is successful, a confirmation message is returned."
                        )
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
