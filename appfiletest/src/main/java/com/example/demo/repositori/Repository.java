package com.example.demo.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;

public interface Repository extends CrudRepository<Person, Long> {

}
