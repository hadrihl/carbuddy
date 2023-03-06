package com.example.carbuddy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Bidder getBidderByItemId(Item item) {
		return bidRepository.findBidderByHighestBid(item, item.getCurrentBid());
	}
	
	public Bidder addBidder(Bidder bidder) {
		return bidderRepository.save(bidder);
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
	
}
 