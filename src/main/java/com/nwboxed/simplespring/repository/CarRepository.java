package com.nwboxed.simplespring.repository;

import com.nwboxed.simplespring.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {

}
