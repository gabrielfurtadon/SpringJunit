package br.com.Gabriel.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean //CRIAR INJEÇÃO DA INSTANCIA E DEIXAR QUE O SPRING FAÇA O GERENCIAMENTO
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
}
