package com.sneupane.practice;

import com.sneupane.practice.model.Person;
import com.sneupane.practice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SbootcouchbaseApplication {
	@Autowired
	private PersonRepository personRepo;

	public static void main(String[] args) {
		SbootcouchbaseApplication cp = new SbootcouchbaseApplication();
		Person saveperson = cp.savePerson();
		SpringApplication.run(SbootcouchbaseApplication.class, args);
	}

	private Person savePerson(){
		Person person = new Person();
		person.setCreated(new Date());
		person.setFirstName("Sudarshan Neupane");
		person.setId("12345678");
		return this.personRepo.save(person);

	}
}
