package com.example.carbuddy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private Float originalPrice;
	
	private Float currentBid;
	
	@OneToMany(mappedBy = "item", orphanRemoval = true)
	private Set<Bid> bids = new HashSet<>();
	
	@Column(name = "endTime")
	private LocalDateTime endTime;
	
	@Column(name = "duration")
	private Duration duration = Duration.ofMinutes(20); // default duration 20 mins
	
	// constructor
	public Item() {
		this.endTime = LocalDateTime.now().plus(duration);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(Float currentBid) {
		this.currentBid = currentBid;
	}
	
	// check whether the current time is after 
	// the `end-time` indicating the auction has ended
	public boolean isExpired() {
		return LocalDateTime.now().isAfter(endTime);
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Float getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Float originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	
}
