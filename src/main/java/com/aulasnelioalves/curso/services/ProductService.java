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

import com.aulasnelioalves.curso.entities.Product;
import com.aulasnelioalves.curso.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		
		return repository.findAll();
	}
	
	public Product findByID(Long id) {
		Optional<Product> obj = repository.findById(id);
		
		return obj.get();
	}

	public Product insert(Product product){
		return repository.save(product);
	}

	public void delete(Long id){
		try{
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DatabaseException(e.getMessage());
		}

	}

	public Product update(Long id, Product product){
		try{
			Product entity = repository.getReferenceById(id);
			updateData(entity, product);
			return entity;
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(Product entity, Product obj){

		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setImgUrl(obj.getImgUrl());
	}

	
}
