package com.example.carbuddy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carbuddy.entity.Item;
import com.example.carbuddy.repository.ItemRepository;
import com.example.carbuddy.repository.UserRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Item addItem(Item item, String username) {
		item.setUser(userRepository.findByUsername(username));
		return itemRepository.save(item);
	}
	
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
}
