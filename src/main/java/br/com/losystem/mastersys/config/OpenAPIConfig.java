package br.com.losystem.mastersys.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Academia API")
                        .description("""
                                        API para gerenciamento de academia incluindo: 
                                        
                                        - Cadastro de aluno
                                        - Matrículas e planos
                                        - Controle financeiro
                                        - Relatórios gerenciais
                                        
                                        Projeto desenvoldio com Spring Boot
                                        """
                                )
                        .version("V1.0.0")
                        .contact(new Contact()
                                .name("Lucas Rodrigues de Oliveira")
                                .email("lucas-oliveira25@outlook.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                )
                .servers(List.of(new Server()
                        .url("http://localhost:8080")
                        .description("Servidor local")))
                .externalDocs(new ExternalDocumentation().description("Documentação do projeto").url("github"));
    }

}
