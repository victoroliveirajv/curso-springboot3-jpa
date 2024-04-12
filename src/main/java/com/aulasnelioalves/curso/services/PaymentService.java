package com.aulasnelioalves.curso.services;

import com.aulasnelioalves.curso.entities.Payment;
import com.aulasnelioalves.curso.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	public List<Payment> findAll(){
		
		return repository.findAll();
	}
	
	public Payment findByID(Long id) {
		Optional<Payment> obj = repository.findById(id);
		
		return obj.get();
	}
	
}
