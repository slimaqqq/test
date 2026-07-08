package com.nwboxed.simplespring.repository;

import com.nwboxed.simplespring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}


