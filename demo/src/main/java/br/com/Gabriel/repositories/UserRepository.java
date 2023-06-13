package br.com.Gabriel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Gabriel.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email); //O JPA CONSEGUE BUSCAR PELO EMAIL SÓ PELA SEMANTICA DO CÓDIGO !

}
