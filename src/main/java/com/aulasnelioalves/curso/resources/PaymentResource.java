package com.aulasnelioalves.curso.resources;

import com.aulasnelioalves.curso.entities.Payment;
import com.aulasnelioalves.curso.entities.User;
import com.aulasnelioalves.curso.services.PaymentService;
import com.aulasnelioalves.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	

	@Autowired
	private PaymentService service;
	
	
	@GetMapping
	public ResponseEntity<List<Payment>> findAll(){
		
		List<Payment> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Long id){
		Payment obj = service.findByID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
