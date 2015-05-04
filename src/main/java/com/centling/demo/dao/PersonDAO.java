package com.centling.demo.dao;

import java.util.List;

import com.centling.demo.entity.Person;

public interface PersonDAO {

	List<Person> findAll();
	void add(Person person);
	void deleteById(String id);
}
