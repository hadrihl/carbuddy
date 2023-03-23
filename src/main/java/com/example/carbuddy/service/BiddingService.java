package com.example.carbuddy.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carbuddy.entity.Bid;
import com.example.carbuddy.entity.Item;
import com.example.carbuddy.entity.User;
import com.example.carbuddy.repository.BidRepository;
import com.example.carbuddy.repository.ItemRepository;
import com.example.carbuddy.repository.UserRepository;

@Service
public class BiddingService {
	
	@Autowired private ItemRepository itemRepository;
	
	@Autowired private BidRepository bidRepository;
	
	@Autowired private UserRepository userRepository;

	public Item addItem(Item item) {
		System.err.println("item.name: " + item.getName());
		System.err.println("item.description: " + item.getDescription());
		System.err.println("item.currentBid: " + item.getCurrentBid());
		return itemRepository.save(item);
	}
	
	public Item updateItem(Long item_id, Item item) {
		Item existedItem = itemRepository.findById(item_id).get();
		existedItem.setName(item.getName());
		existedItem.setDescription(item.getDescription());
		existedItem.setOriginalPrice(item.getOriginalPrice());
		existedItem.setEndTime(item.getEndTime());
		existedItem.setDuration(item.getDuration());
		return itemRepository.save(existedItem);
	}
	
	public Item getItemById(Long id) {
		return itemRepository.findById(id).get();
	}
	
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	public void deleteItemByItemId(Long item_id) {
		itemRepository.deleteById(item_id);
	}
	
	public User getBidderByItemId(Item item) {
		return bidRepository.findBidderByHighestBid(item, item.getCurrentBid());
	}
	
	public User getBidderByBidderId(Long user_id) {
		return userRepository.findById(user_id).get();
	}
	
	public User addBidder(User user) {
		return userRepository.save(user);
	}
	
	public User updateUserProfile(Long user_id, User user) {
		User tmp = userRepository.findById(user_id).get();
		tmp.setUsername(user.getUsername());
		tmp.setEmail(user.getEmail());
		
		return userRepository.save(tmp);
	} 
	
	public List<User> getAllBidders() {
		return userRepository.findAll();
	}
	
	public Bid bidItem(Long item_id, String username, Bid bid) {
		Item item = itemRepository.findById(item_id).get();
		
		if(bid.getAmount() > item.getCurrentBid()) {
			item.setCurrentBid(bid.getAmount());
			itemRepository.save(item);
			bid.setItem(item);
			bid.setUser(userRepository.findUserByUsername(username));
			bidRepository.save(bid);
		}
		
		return bid;
	}
	
	public Bid getBidByItemId(Long item_id, Float currentBid) {
		return bidRepository.findBidByHighestBid(item_id, currentBid);
	}
	
	public void deleteUserById(Long user_id) {
		userRepository.deleteById(user_id);
	}
	
	public void extendAuctionTime(Long item_id) {
		Item item = itemRepository.findById(item_id).get();
		item.setEndTime(LocalDateTime.now().plus(item.getDuration()));
		itemRepository.save(item);
	}
}
 