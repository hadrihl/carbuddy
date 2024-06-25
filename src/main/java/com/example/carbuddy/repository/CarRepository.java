package com.example.carbuddy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.carbuddy.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

	@Query(value = "SELECT c FROM Car c WHERE c.brand LIKE '%' || :keyword || '%'"
			+ " OR c.model LIKE '%' || :keyword || '%'"
			+ " OR c.description LIKE '%' || :keyword || '%'"
			+ " OR c.year LIKE '%' || :keyword || '%'"
			+ " OR c.variant LIKE '%' || :keyword || '%'"
			+ " OR c.transmission LIKE '%' || :keyword || '%'"
			+ " OR c.fueltype LIKE '%' || :keyword || '%'"
			+ " OR c.location LIKE '%' || :keyword || '%'"
			)
	public List<Car> search(@Param("keyword") String keyword);
}
