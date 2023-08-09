package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		
		logger.info("Finding All!");
		
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i < 8; i++ ) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}

	public Person findById(String id) {
		
		logger.info("Finding a person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Caleb");
		person.setLastName("Wacht");
		person.setAddress("Cascavel - Paraná - Brasil");
		person.setGender("Male");
		return person;
	}
	
	private Person mockPerson(int i) {		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Las name " + i);
		person.setAddress("Address " + i);
		person.setGender("Male");
		return person;
	}
}
