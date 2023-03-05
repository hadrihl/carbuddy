package com.example.carbuddy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

	@Query("SELECT b.bidder FROM Bid b WHERE b.item = :item AND b.amount = :amount")
	public Bidder findBidderByHighestBid(Item item, Float amount);
	
	@Query("SELECT b FROM Bid b WHERE b.item.id = :item_id AND b.amount = :currentBid")
	public Bid findBidByHighestBid(Long item_id, Float currentBid);
}
