package com.example.carbuddy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carbuddy.entity.Car;
import com.example.carbuddy.repository.CarRepository;

@Service
@Transactional
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

}
