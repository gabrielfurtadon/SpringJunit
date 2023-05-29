package br.com.Gabriel.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Gabriel.domain.User;
import br.com.Gabriel.repositories.UserRepository;
import br.com.Gabriel.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> obj = repository .findById(id);
		return obj.orElse(null);
	}

	
	
}