package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Person;
import com.example.demo.repositori.Repository;

@org.springframework.stereotype.Service
@Transactional
public class Service {
	
	@Autowired Repository repo;
	public List<Person> getall() {
		// TODO Auto-generated method stub
		
		return (List<Person>) repo.findAll();
	}
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return repo.save(person);
	}
	public Person findOne(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	public Person update(Person person) {
		// TODO Auto-generated method stub
		return repo.save(person);
	}
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

}
