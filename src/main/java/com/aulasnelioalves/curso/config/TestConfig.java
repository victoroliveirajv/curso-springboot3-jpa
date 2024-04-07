package com.aulasnelioalves.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulasnelioalves.curso.entities.Category;
import com.aulasnelioalves.curso.entities.Order;
import com.aulasnelioalves.curso.entities.Product;
import com.aulasnelioalves.curso.entities.User;
import com.aulasnelioalves.curso.entities.enums.OrderStatus;
import com.aulasnelioalves.curso.repositories.CategoryRepository;
import com.aulasnelioalves.curso.repositories.OrderRepository;
import com.aulasnelioalves.curso.repositories.ProductRepository;
import com.aulasnelioalves.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5,"");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0,"");
		Product p3 = new Product(null, "Macbook Pro.","Nam eleifend maximus tortor, at mollis", 1250.0,"");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquer odio ac rhoncus cursus.", 1200.0,"");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99,"");
		
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c3);
		p2.getCategories().add(c1);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98788898", "1234568");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "84635655", "1234568");
				
		Order o1 = new Order(null, Instant.parse("2024-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2024-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2024-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		

		userRepository.saveAll(Arrays.asList(u1, u2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	
	}

}
