package com.safetynetalerts.api.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.safetynetalerts.api.datajson.DataFile;
import com.safetynetalerts.api.datajson.JsonConverter;
import com.safetynetalerts.api.entities.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Override
	public List<Person> getPersons() throws IOException {
		List<Person> listPersons = new ArrayList<Person>();
		listPersons = ((DataFile) JsonConverter.ReadObjectFromJson(DataFile.class)).getPersons();
		JsonConverter.convertObjectToJson(listPersons);
		return listPersons;
	}

	@Override
	public Person getPerson(String firstName, String lastName) throws IOException {
		Person person = new Person();		
		Predicate<Person> byFirstLastName = p -> p.getFirstName().contains(firstName) && p.getLastName().contains(lastName);
		person = this.getPersons().stream().filter(byFirstLastName).collect(Collectors.toList()).get(0);
		return person;
	}

	@Override
	public Person addPerson(Person person) throws IOException {
		List<Person> listPersons = new ArrayList<Person>();
		listPersons = this.getPersons();
		listPersons.add(person);
		JsonConverter.updatePersons(listPersons);
		return person;
	}

	
	//!\ aller chercher l info pour la changer
	@Override
	public Person updatePerson(Person person) throws IOException {	
		this.deletePerson(person.getFirstName(), person.getLastName());
		this.addPerson(person);
		return person;
	}

	@Override
	public boolean deletePerson(String firstName, String lastName) throws IOException {
		List<Person> listPersons = new ArrayList<Person>();
		listPersons = this.getPersons();
		Predicate<Person> byFirstLastName = p -> p.getFirstName().contains(firstName) && p.getLastName().contains(lastName);
		listPersons.removeIf(byFirstLastName);
		JsonConverter.updatePersons(listPersons);
		return true;
	}

}
