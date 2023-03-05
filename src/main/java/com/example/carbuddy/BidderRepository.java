package com.example.carbuddy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BidderRepository extends JpaRepository<Bidder, Long> {

	@Query("SELECT b FROM Bidder b WHERE b.username = :username")
	public Bidder findBidderByUsername(String username);
}
