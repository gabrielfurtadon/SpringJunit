package br.com.Gabriel.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Gabriel.domain.User;
import br.com.Gabriel.domain.dto.UserDTO;
import br.com.Gabriel.repositories.UserRepository;
import br.com.Gabriel.service.UserService;
import br.com.Gabriel.service.exceptions.DataIntegratyViolationException;
import br.com.Gabriel.service.exceptions.ObjectNotFoundException;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> obj = repository .findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User create(UserDTO obj) {
		findByEmail(obj); //SE NÃO COLOCAR AQUI PARA VERIFICAR ELE NUNCA VA EXTOURAR A EXCESSÃO
		return repository.save(mapper.map(obj, User.class));
	}
	
	
	private void findByEmail(UserDTO obj) {
		Optional<User> user = repository.findByEmail(obj.getEmail());
		if(user.isPresent() && !user.get().getId().equals(obj.getId())) { // verifica tambem se o id do usuario for diferente do que está sendo buscado o email
			throw new DataIntegratyViolationException("Email já cadastrado no sistema");
		}
	}

	@Override
	public User update(UserDTO obj) {
		findByEmail(obj); //ANTES DE ATUALIZAR VER SE JÁ NÃO TEM UM EMAIL IGUAL CADASTRADO
		return repository.save(mapper.map(obj, User.class));
	}

	
	
}
