package br.com.Gabriel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Gabriel.domain.User;
import br.com.Gabriel.repositories.UserRepository;
import br.com.Gabriel.service.UserService;
import br.com.Gabriel.service.exceptions.ObjectNotFoundException;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> obj = repository .findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}

	
	
}
