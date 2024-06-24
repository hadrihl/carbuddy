package com.example.carbuddy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.carbuddy.entity.Role;

public class RoleRepositoryTest {

	@Test
	public void testRoleConstructor() {
		Role role = new Role("USER");
		assertEquals("USER", role.getName());
		
		Role role2 = new Role("ADM");
		assertEquals("ADM", role2.getName());
	}
}
