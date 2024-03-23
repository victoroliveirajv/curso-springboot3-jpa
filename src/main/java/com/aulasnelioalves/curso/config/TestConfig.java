package com.aulasnelioalves.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulasnelioalves.curso.entities.User;
import com.aulasnelioalves.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98788898", "1234568");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "84635655", "1234568");
				
		userRepository.saveAll(Arrays.asList(u1, u2));
	
	}

}
