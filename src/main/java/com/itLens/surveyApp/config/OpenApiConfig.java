package com.itLens.surveyApp.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI defineOpenApi(){
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Local server");

        Contact contact = new Contact();
        contact.setName("AMine El karroudi");
        contact.setEmail("amineelkarroudi04@proton.me");
        contact.setUrl("amineelkarroudi.com");

        Info info = new Info()
                .title("waiting room app")
                .version("1.0")
                .description("This is a simple waiting room app")
                .contact(contact);

        return new OpenAPI().info(info).servers(List.of(server));
    }

}
