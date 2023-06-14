package br.com.Gabriel.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.Gabriel.domain.User;
import br.com.Gabriel.domain.dto.UserDTO;
import br.com.Gabriel.service.UserService;

@RestController
@RequestMapping(value = "/users") 
public class UserController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserService service;
	
	
//	@GetMapping(value = "/{id}")
//	public  ResponseEntity<User> findById(@PathVariable Long id){ // dando ao client acesso à entidade User (não é interessante, problema de segurança)
//		
//		return ResponseEntity.ok().body(service.findById(id));
//		
//	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<UserDTO> findById(@PathVariable Long id){ // dando ao client acesso à entidade User (não é interessante, problema de segurança)
		
		return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
		
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> listDTO = service.findAll().stream().map(x -> mapper.map(x, UserDTO.class)).collect(Collectors.toList()); //VER JAVA STREAM 
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj) {
		User newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO obj) {
		obj.setId(id); //GARANTIR QUE O ID É O ID DA URL
		User newObj = service.update(obj);
		return ResponseEntity.ok().body(mapper.map(newObj, UserDTO.class));
	}
	
	
}
