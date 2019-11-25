package fr.efrei.JPA_Test;

import org.springframework.beans.factory.annotation.Autowired;
import fr.efrei.JPA_Test.Person;
import fr.efrei.JPA_Test.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonRestWebService {

	PersonRepository personRepository;
	
	@Autowired
	public PersonRestWebService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
	
	@GetMapping("/personns")
	public Iterable<Person> getPersons(){
		return personRepository.findAll();
	}
}