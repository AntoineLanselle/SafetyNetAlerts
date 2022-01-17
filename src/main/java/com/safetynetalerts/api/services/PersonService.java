package com.safetynetalerts.api.services;

import java.io.IOException;
import java.util.List;
import com.safetynetalerts.api.entities.Person;

public interface PersonService {

	public List<Person> getPersons() throws IOException;	
	
	public Person getPerson(String firstName, String lastName) throws IOException;
	
	public Person addPerson(Person person) throws IOException;
	
	public Person updatePerson(Person person) throws IOException;
	
	public boolean deletePerson(String firstName, String lastName) throws IOException;
	
}
