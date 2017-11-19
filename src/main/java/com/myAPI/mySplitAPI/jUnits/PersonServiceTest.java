package com.myAPI.mySplitAPI.jUnits;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myAPI.mySplitAPI.entity.Person;
import com.myAPI.mySplitAPI.service.PersonService;

public class PersonServiceTest {

	
	PersonService personService = new PersonService();

	@Test
	public void testGetAllUsers() {

		List<Person> listofPersons = personService.getAllUsers();
		assertNotNull("This is null", listofPersons);
		assertTrue(listofPersons.get(0).getName().equals("Girish"));
	}

	@Test
	public void testGetAllUsersCount() {
		assertTrue(personService.getAllUsersCount() > 1);
	}

	@Test
	public void testGetUserByName() {
		assertNotNull(personService.getUserByName("Girish"));
	}

	@Test
	public void testAddPerson()
	{
		Person invalidEntry = Person.builder().name("abcd").email("ssss@ss.com").UOwe(11).IOwe(102).build();
		personService.addUser(invalidEntry);
		
		assertNotNull(personService.getUserByName("abcd"));
	}

}
