package br.com.sartori.employeesmanagement.infrastructure.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de Gestão de Funcionários - MJV - Santander")
                        .description("API Rest da aplicação Sistema de Gestão de Funcionários")
                        .contact(new Contact()
                                .name("Rodrigo Sartori")
                                .email("93sartori@gmail.com")));
    }


}