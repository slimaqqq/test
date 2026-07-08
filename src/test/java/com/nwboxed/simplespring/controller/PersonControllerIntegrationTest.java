package com.nwboxed.simplespring.controller;

import com.nwboxed.simplespring.model.Person;
import com.nwboxed.simplespring.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository.deleteAll();
    }

    @Test
    void addViaGet_shouldCreatePerson() {
        ResponseEntity<Person> response = restTemplate.getForEntity("/persons/add?name=Jan&surname=Kowalski", Person.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        Person created = response.getBody();
        assertThat(created).isNotNull();
        assertThat(created.getId()).isNotNull();
        assertThat(created.getName()).isEqualTo("Jan");
        assertThat(created.getSurname()).isEqualTo("Kowalski");

        List<Person> all = personRepository.findAll();
        assertThat(all).hasSize(1);
    }

    @Test
    void post_shouldCreatePerson() {
        Person p = new Person(null, "Anna", "Nowak");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Person> req = new HttpEntity<>(p, headers);

        ResponseEntity<Person> response = restTemplate.postForEntity("/persons", req, Person.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        Person created = response.getBody();
        assertThat(created).isNotNull();
        assertThat(created.getId()).isNotNull();
        assertThat(created.getName()).isEqualTo("Anna");

        List<Person> all = personRepository.findAll();
        assertThat(all).hasSize(1);
    }

    @Test
    void list_shouldReturnAllPersons() {
        personRepository.save(new Person(null, "A", "One"));
        personRepository.save(new Person(null, "B", "Two"));

        ResponseEntity<List<Person>> response = restTemplate.exchange(
                "/persons",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Person>>() {
                }
        );

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        List<Person> list = response.getBody();
        assertThat(list).isNotNull();
        assertThat(list).hasSize(2);
    }

}

