package br.edu.atitus.pooavancado.CadUsuario.comum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ConfigSwagger {
	
	 @Bean
	 public OpenAPI customOpenAPI() {
	 	return new OpenAPI()
	 			.info(new Info().title("Documentação da API realizada para o trabalho G2").description("Descrição")
	 			.contact(new Contact().name("Estudante de Ciência da Computação - Jovita").email("1135184@atitus.edu.br"))
	 			.version("version 1.0.0"));
	 }
}
