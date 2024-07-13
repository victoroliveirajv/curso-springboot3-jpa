package com.aulasnelioalves.curso.services;

import java.util.List;

import com.aulasnelioalves.curso.services.exceptions.DatabaseException;
import com.aulasnelioalves.curso.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
		Category obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		return obj;
	}

	public Category insert(Category category){
		return repository.save(category);
	}

	public Category update(Long id, Category category){

		try{
			Category newCategory = repository.getReferenceById(id);
			updateDate(newCategory, category);


			return repository.save(newCategory);

		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateDate(Category newCategory, Category category) {

		newCategory.setName(category.getName());
		newCategory.getProducts().addAll(category.getProducts());

	}

	public void delete(Long id){
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DatabaseException(e.getMessage());
		}
	}
}
