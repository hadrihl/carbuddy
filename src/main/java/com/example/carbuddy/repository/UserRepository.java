package com.example.carbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.carbuddy.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User findByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);
}
