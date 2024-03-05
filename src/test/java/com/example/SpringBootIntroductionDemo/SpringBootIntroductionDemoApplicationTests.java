package com.example.SpringBootIntroductionDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootIntroductionDemoApplicationTests {

	@Autowired
	PizzaRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testPizza() {
		repository.save(new Pizza("Capricciosa", 89));
		repository.save(new Pizza("Kebab", 99));
		repository.save(new Pizza("Margarita", 75));

		List<Pizza> pizzas = (List)repository.findAll();

		repository.deleteById(1L);

		Pizza pizza = repository.findById(2L).orElse(null);
		pizza.setPrice(149);

		repository.save(pizza);

		pizzas = (List)repository.findAll();

		List<Pizza> margaritas = repository.findByName("Margarita");



	}

}
