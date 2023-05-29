package br.com.Gabriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Gabriel.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
