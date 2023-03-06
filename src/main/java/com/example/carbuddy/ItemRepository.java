package com.example.carbuddy;

import java.time.Duration;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query("SELECT i from Item i WHERE i.duration = :duration")
	public Item findItemByDuration(Duration duration);
	
	@Query("SELECT i from Item i WHERE i.endTime = :endTime")
	public Item findItemByEndTime(LocalDate endTime);
	
	@Query("SELECT i from Item i WHERE i.name = :name")
	public Item findItemByItemName(String name);
	
	@Query("SELECT i from Item i WHERE i.description = :description")
	public Item findItemByItemDescription(String description);
}
