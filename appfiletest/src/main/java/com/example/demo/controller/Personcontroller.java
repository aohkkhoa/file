package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Personcontroller {

	@Autowired Service service;
	
	public static Date haha; 
	
	@GetMapping("/haha/{hihi}")
	public ResponseEntity<Response> hihi(@PathVariable("hihi") String hihi){
		return new ResponseEntity<Response>(new Response(hihi+"haha"),HttpStatus.OK); 
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Person>> getperson(){
		List<Person> person = service.getall();
		return new ResponseEntity<List<Person>>(person, HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity<Person> save(@RequestBody Person person)  {
		if(person == null) {
			throw new NullPointerException("person object cannot be null");
		}
		person.setCreateDate(new Date());
		haha = person.setCreateDate(new Date());
		Person dbperson = service.save(person);
		return new ResponseEntity<Person>(dbperson, HttpStatus.OK);
	}
	@GetMapping("/getperson/{id}")
	public ResponseEntity<Person> getperson(@PathVariable("id") Long id)  {
		if(id == null) {
			throw new NullPointerException("person object cannot be null");
		}
		
		Person dbperson = service.findOne(id);
		return new ResponseEntity<Person>(dbperson, HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Person> update(@RequestBody Person person)  {
		if(person == null) {
			throw new NullPointerException("person object cannot be null");
		}
		person.setCreateDate(haha);
		person.setUpdateDate(new Date());
		Person dbperson = service.update(person);
		return new ResponseEntity<Person>(dbperson, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleEntity(@PathVariable("id") Long id)  {
		if(id == null) {
			throw new NullPointerException("person object cannot be null");
		}
		
		 service.delete(id);
		return new ResponseEntity<Response>( new Response("person is delete"), HttpStatus.OK);
	}
}
