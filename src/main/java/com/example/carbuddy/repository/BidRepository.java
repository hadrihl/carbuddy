package com.example.carbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.carbuddy.entity.Bid;
import com.example.carbuddy.entity.Item;
import com.example.carbuddy.entity.User;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

	@Query("SELECT b.user FROM Bid b WHERE b.item = :item AND b.amount = :amount")
	public User findBidderByHighestBid(Item item, Float amount);
	
	@Query("SELECT b FROM Bid b WHERE b.item.id = :item_id AND b.amount = :currentBid")
	public Bid findBidByHighestBid(Long item_id, Float currentBid);
}
