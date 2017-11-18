package com.myAPI.mySplitAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myAPI.mySplitAPI.entity.Person;
import com.myAPI.mySplitAPI.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService pService;
	
	@RequestMapping("/persons")
	public List<Person> getAllUsers()
	{
		return pService.getAllUsers();
	}
	
	@RequestMapping("/totalUsers")
	public int getCountofUsers()
	{
		return pService.getAllUsersCount();
	}
	
	@RequestMapping("/persons/{name}")
	public Person getUserByName(@PathVariable String name)
	{
		return pService.getUserByName(name);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/persons/{name}")
	public String deleteUserByName(@PathVariable String name)
	{
		return pService.removeUserByName(name);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/persons")
	public String addUser(@RequestBody Person p)
	{
		return pService.addUser(p);
	}

}
