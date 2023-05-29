package br.com.Gabriel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Gabriel.domain.User;
import br.com.Gabriel.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<User> findById(@PathVariable Long id){
		
		return ResponseEntity.ok().body(service.findById(id));
		
	}
	
}
