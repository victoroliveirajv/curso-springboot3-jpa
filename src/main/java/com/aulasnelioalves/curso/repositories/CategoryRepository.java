package com.aulasnelioalves.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aulasnelioalves.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
