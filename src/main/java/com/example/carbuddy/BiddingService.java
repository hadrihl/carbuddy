package com.example.carbuddy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BiddingService {
	
	@Autowired private ItemRepository itemRepository;
	
	@Autowired private BidRepository bidRepository;
	
	@Autowired private BidderRepository bidderRepository;

	public Item addItem(Item item) {
		System.err.println("item.name: " + item.getName());
		System.err.println("item.description: " + item.getDescription());
		System.err.println("item.currentBid: " + item.getCurrentBid());
		return itemRepository.save(item);
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
	
	public Bidder getBidderByItemId(Item item) {
		return bidRepository.findBidderByHighestBid(item, item.getCurrentBid());
	}
	
	public Bidder getBidderByBidderId(Long user_id) {
		return bidderRepository.findById(user_id).get();
	}
	
	public Bidder addBidder(Bidder bidder) {
		return bidderRepository.save(bidder);
	}
	
	public Bidder updateUserProfile(Long user_id, Bidder user) {
		Bidder tmp = bidderRepository.findById(user_id).get();
		tmp.setUsername(user.getUsername());
		tmp.setEmail(user.getEmail());
		
		return bidderRepository.save(tmp);
	} 
	
	public List<Bidder> getAllBidders() {
		return bidderRepository.findAll();
	}
	
	public Bid bidItem(Long item_id, String username, Bid bid) {
		Item item = itemRepository.findById(item_id).get();
		
		if(bid.getAmount() > item.getCurrentBid()) {
			item.setCurrentBid(bid.getAmount());
			itemRepository.save(item);
			bid.setItem(item);
			bid.setBidder(bidderRepository.findBidderByUsername(username));
			bidRepository.save(bid);
		}
		
		return bid;
	}
	
	public Bid getBidByItemId(Long item_id, Float currentBid) {
		return bidRepository.findBidByHighestBid(item_id, currentBid);
	}
	
	public void deleteUserById(Long user_id) {
		bidderRepository.deleteById(user_id);
	}
	
	public void extendAuctionTime(Long item_id) {
		Item item = itemRepository.findById(item_id).get();
		item.setEndTime(LocalDateTime.now().plus(item.getDuration()));
		itemRepository.save(item);
	}
}
 