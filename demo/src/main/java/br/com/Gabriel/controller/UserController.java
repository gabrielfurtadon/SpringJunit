package br.com.Gabriel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Gabriel.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping(value = "/{id}")
	public  ResponseEntity<User> findById(@PathVariable Long id){
		
		return ResponseEntity.ok().body(new User(1L, "Gabriel", "gabrielfneves2001@gmail.com", "1234"));
		
	}
	
}
