package com.sneupane.practice.repository;

import com.sneupane.practice.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sudarshan on 1/12/17.
 */
public interface PersonRepository extends CrudRepository<Person,String> {
    List<Person> findByFirstName(String firstName);
}
