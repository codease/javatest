package com.centling.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.centling.demo.dao.PersonDAOImpl;
import com.centling.demo.entity.Person;

@Service("personService")
public class PersonService {
	
	@Resource
	PersonDAOImpl personDAO;
	
	public List<Person> findAll() {
		return personDAO.findAll();
	}
	
	public void add(Person person) {
		personDAO.add(person);
	}
	
	public void deleteById(String id) {
		personDAO.deleteById(id);
	}
	
}
