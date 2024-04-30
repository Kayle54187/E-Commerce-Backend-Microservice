package com.kvs.ordersservice.Config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Kayle San");
        myContact.setEmail("habichristi@gmail.com");

        Info information = new Info()
                .title("Orders Service")
                .version("1.0")
                .description("This API exposes endpoints to manage all orders.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
