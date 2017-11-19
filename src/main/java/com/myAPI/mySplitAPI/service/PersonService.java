package com.myAPI.mySplitAPI.service;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.myAPI.mySplitAPI.entity.Person;

@Service
public class PersonService {

	private List<Person> personsList = new ArrayList<Person>(Arrays.asList(

			new Person("Girish", "gedalagirish27@gmail.com", 16, 222),
			new Person("Sushma", "sushmakandru24@gmail.com", 10, 22),
			new Person("Harsha", "harshakandru24@gmail.com", 10, 252)

	));

	public List<Person> getAllUsers() {
		return personsList;
	}

	public int getAllUsersCount() {
		return personsList.size();
	}

	public Person getUserByName(String name) {
		for (Person p : personsList) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	public String addUser(Person p) {
		if (personsList.add(p))
			return "success";
		else
			return "failed";
	}

	public String removeUserByName(String name) {
		for (Person p : personsList) {
			if (p.getName().equals(name)) {
				personsList.remove(p);
				return "user deleted";
			}
		}
		return "failed, no user found";
	}

	public String updateUserByName(String name, Person updatedProfile) {
		for (Person p : personsList) {
			if (p.getName().equals(name)) {
				personsList.remove(p);
				return "user updated";
			}
		}
		return "failed, no user found";
	}
}
