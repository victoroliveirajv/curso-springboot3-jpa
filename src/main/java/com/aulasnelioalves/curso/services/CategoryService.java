package com.aulasnelioalves.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aulasnelioalves.curso.entities.Category;
import com.aulasnelioalves.curso.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {

		return repository.findAll();
	}

	public Category findByID(Long id) {
		Optional<Category> obj = repository.findById(id);
		
		return obj.get();
	}	
}
