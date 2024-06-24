package com.example.carbuddy.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.carbuddy.entity.Item;
import com.example.carbuddy.entity.User;
import com.example.carbuddy.repository.RoleRepository;
import com.example.carbuddy.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired private RoleRepository roleRepository;
	@Autowired private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(Long user_id) {
		return userRepository.findById(user_id).get();
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User updateUser(Long id, User tmp, String role_admin) {
		User user = userRepository.findById(id).get();
		user.setUsername(tmp.getUsername());
		user.setEmail(tmp.getEmail());
		
		// update ROLE_ADMIN
		if(role_admin.contentEquals("on")) {
			user.addRoles(roleRepository.findRoleByName("ROLE_ADMIN"));
		} else {
			user.removeRoles(roleRepository.findRoleByName("ROLE_ADMIN"));
		}
		
		return userRepository.save(user);
	}
	
	public void deleteUser(Long user_id) {
		userRepository.deleteById(user_id);
	}
	
	public void createUser(User tmp) {
		
		if(userRepository.findByUsername(tmp.getUsername()) == null) {
			User user = new User();
			user.setUsername(tmp.getUsername());
			user.setEmail(tmp.getEmail());
			
			user.setPassword(new BCryptPasswordEncoder().encode(tmp.getPassword()));
			user.addRoles(roleRepository.findRoleByName("USER"));
			userRepository.save(user);
		}
		
	}
	
	public List<Item> getAllItemsByUsername(String username) {
		User user = userRepository.findByUsername(username);
		List<Item> items = user.getItems();
		
		return items;
	}
}
 