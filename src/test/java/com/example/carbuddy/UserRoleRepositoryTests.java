package com.example.carbuddy;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.example.carbuddy.entity.Role;
import com.example.carbuddy.entity.User;
import com.example.carbuddy.repository.RoleRepository;
import com.example.carbuddy.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRoleRepositoryTests {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void createRolesTest() {
		Role ADMIN = new Role("ROLE_ADMIN");
		Role USER = new Role("ROLE_USER");
		roleRepository.saveAll(List.of(ADMIN, USER));
	}
	
	@Test
	public void createAdminAccountTest() {
		User admin = new User();
		admin.setUsername("admin");
		admin.setEmail("admin@example.com");
		admin.setPassword(new BCryptPasswordEncoder().encode("password"));
		admin.addRoles(roleRepository.findRoleByName("ROLE_ADMIN"));
		userRepository.save(admin);
	}
	
	@Test
	public void createUserAccountTest() {
		User david = new User();
		david.setUsername("david");
		david.setEmail("david@example.com");
		david.setPassword(new BCryptPasswordEncoder().encode("password"));
		david.addRoles(roleRepository.findRoleByName("ROLE_USER"));
		userRepository.save(david);
	}
}
