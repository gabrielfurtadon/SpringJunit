package br.com.Gabriel.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.Gabriel.domain.User;
import br.com.Gabriel.repositories.UserRepository;

@Configuration
@Profile("local")
public class localConfig {
	
	@Autowired
	private UserRepository repository;
	
	@Bean
	public void startDB(){
		User u1 = new User(null, "Gabriel", "gabriel@gmail.com", "123");
		User u2 = new User(null, "Laura", "laura@gmail.com", "123");
		
		repository.saveAll(List.of(u1, u2));
	}
}
