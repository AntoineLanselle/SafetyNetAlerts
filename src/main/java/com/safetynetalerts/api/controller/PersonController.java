package com.safetynetalerts.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalerts.api.entities.Person;
import com.safetynetalerts.api.services.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	//get la liste de toutes les personnes
	@GetMapping("/persons")
	public List<Person> getPersons() throws IOException {
		return this.personService.getPersons();
	}
	
	//get un personne en particulier en utilisant une combinaison de prénom et de nom comme identificateur unique
	@GetMapping("/person")
	public Person getPerson(@RequestParam(name="firstName", required=true) String firstName, @RequestParam(name="lastName", required=true)String lastName) throws IOException {
		return this.personService.getPerson(firstName, lastName);
	}
	
	//ajouter une nouvelle personne 
	@PostMapping("/person")
	public Person addPerson(@RequestBody Person person) throws IOException {
		return this.personService.addPerson(person);
	}
	
	//update une personne avec une requete PUT
	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) throws IOException {
		return this.personService.updatePerson(person);
	}		
	
	//supprime une personne en particulier en utilisant une combinaison de prénom et de nom comme identificateur unique
	@DeleteMapping("/person")
	public boolean deletePerson(@RequestParam(name="firstName", required=true) String firstName, @RequestParam(name="lastName", required=true)String lastName) throws IOException {
		return this.personService.deletePerson(firstName, lastName);
	}
	
}
