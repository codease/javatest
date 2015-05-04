package com.centling.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "person")
public class Person {

	private String id;
	private String name;
	private String address;
		
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() { 
		return id; 
	}
	
	public void setId(String id) {
		this.id = id;
	}

	@Column(length = 100)
	public String getName() { 
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
