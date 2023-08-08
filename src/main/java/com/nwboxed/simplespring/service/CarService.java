package com.nwboxed.simplespring.service;

import com.nwboxed.simplespring.model.Car;
import com.nwboxed.simplespring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car getById(String id) {
        return carRepository.getOne(id);
    }
}