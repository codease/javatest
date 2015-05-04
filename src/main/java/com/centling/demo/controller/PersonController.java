package com.centling.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.centling.demo.entity.Person;
import com.centling.demo.service.PersonService;

@Controller("personController")
@RequestMapping("/person/*")
public class PersonController {

	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Person> persons = personService.findAll();
		model.addAttribute("persons", persons);
		return "demo";
	}
	
	@RequestMapping(value="add")
	public String add() {
		return "add";
	}
	
	@RequestMapping(value="addPerson",method=RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute Person person) {
		personService.add(person);
		List<Person> persons = personService.findAll();
		return new ModelAndView("demo","persons",persons);
	}
	
	@RequestMapping("/add/{name}/{address}")
	public String add(@PathVariable String  name, @PathVariable String address, Model model) {
		Person person = new Person();
		person.setName(name);
		person.setAddress(address);
		personService.add(person);
		List<Person> persons = personService.findAll();
		model.addAttribute("persons", persons);
		return "demo";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		personService.deleteById(id);
		List<Person> persons = personService.findAll();
		model.addAttribute("persons", persons);
		return "demo";
	}
	
	@Resource 
	PersonService personService;
}
