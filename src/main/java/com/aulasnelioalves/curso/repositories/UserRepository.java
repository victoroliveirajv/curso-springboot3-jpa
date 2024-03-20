package com.aulasnelioalves.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulasnelioalves.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
