package com.nwboxed.simplespring.controller;

import com.nwboxed.simplespring.model.Person;
import com.nwboxed.simplespring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Create by POSTing JSON { "name": "John", "surname": "Doe" }
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    // Convenience GET to add via query params: /persons/add?name=John&surname=Doe
    @GetMapping("/add")
    public Person addViaParams(@RequestParam String name, @RequestParam String surname) {
        Person p = new Person(null, name, surname);
        return personRepository.save(p);
    }

    // List all persons
    @GetMapping
    public List<Person> listPersons() {
        return personRepository.findAll();
    }

}

