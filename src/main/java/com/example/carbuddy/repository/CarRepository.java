package com.example.carbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carbuddy.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

}
