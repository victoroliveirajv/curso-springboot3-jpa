package com.aulasnelioalves.curso.services;

import java.util.List;
import java.util.Optional;

import com.aulasnelioalves.curso.services.exceptions.DatabaseException;
import com.aulasnelioalves.curso.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.aulasnelioalves.curso.entities.User;
import com.aulasnelioalves.curso.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public User findByID(Long id) {
		Optional<User> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user){
		return repository.save(user);
	}

	public void delete(Long id){
		try{
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj){
		try{
			User entity = repository.getReferenceById(id);
			updateDate(entity, obj);
			return repository.save(entity);

		}catch (EntityNotFoundException e){
			throw new ResourceNotFoundException(id);
		}catch (RuntimeException e){
			e.printStackTrace();
		}

	}

	private void updateDate(User entity, User obj){

		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
