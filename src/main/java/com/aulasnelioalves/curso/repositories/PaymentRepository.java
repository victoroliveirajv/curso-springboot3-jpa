package com.aulasnelioalves.curso.repositories;

import com.aulasnelioalves.curso.entities.Payment;
import com.aulasnelioalves.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	

}
