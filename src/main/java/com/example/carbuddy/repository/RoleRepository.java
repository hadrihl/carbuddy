package com.example.carbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.carbuddy.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	@Query("SELECT r FROM Role r WHERE r.name = :name")
	public Role findRoleByName(String name);
}
