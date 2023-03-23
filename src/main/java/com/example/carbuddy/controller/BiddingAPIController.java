package com.example.carbuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carbuddy.entity.Item;
import com.example.carbuddy.service.BiddingService;

@RestController
@RequestMapping("/api/bids")
public class BiddingAPIController {
	
	@Autowired
	private BiddingService biddingService;
	
	@GetMapping
	public List<Item> getAllItems() {
		return biddingService.getAllItems();
	}
	
	@PostMapping
	public Item createItem(@RequestBody Item item) {
		System.err.println("item.name: " + item.getName());
		System.err.println("item.description: " + item.getDescription());
		System.err.println("item.originalPrice: " + item.getOriginalPrice());
		return biddingService.addItem(item);
	}
	
	@GetMapping("/{id}")
	public Item getItemById(@PathVariable("id") Long item_id) {
		return biddingService.getItemById(item_id);
	}
	
	@PutMapping("/{id}")
	public Item updateItemById(@PathVariable("id") Long item_id, @RequestBody Item item) {
		return biddingService.updateItem(item_id, item);
	}
	
	@DeleteMapping("/{id}")
	public void deleteitemByid(@PathVariable("id") Long item_id) {
		biddingService.deleteItemByItemId(item_id);
	}

}
