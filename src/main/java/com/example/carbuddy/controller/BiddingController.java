package com.example.carbuddy.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.carbuddy.entity.Bid;
import com.example.carbuddy.entity.Item;
import com.example.carbuddy.entity.User;
import com.example.carbuddy.service.BiddingService;
import com.example.carbuddy.service.CustomUserDetails;
import com.example.carbuddy.service.UserService;

@Controller
public class BiddingController {
	
	@Autowired private BiddingService biddingService;
	
	@Autowired private UserService userService;

	@GetMapping("/items")
	public String getItemsPage(Model model) {
		model.addAttribute("items", biddingService.getAllItems());
		return "items";
	}
	
	@GetMapping("/add-item")
	public String addItemPage() {
		return "add-item";
	}
	
	@PostMapping("/add-item")
	public String addItem(@ModelAttribute("item") Item item) {
		biddingService.addItem(item);
		return "redirect:/items";
	}
	
	@GetMapping("/users")
	public String getAllBidders(Model model, @AuthenticationPrincipal CustomUserDetails loggedinUser) {
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("username", loggedinUser.getUsername());
		return "users";
	}
	
	@GetMapping("/add-user")
	public String addBidderPage(Model model, @AuthenticationPrincipal CustomUserDetails loggedinUser) {
		model.addAttribute("username", loggedinUser.getUsername());
		return "add-user";
	}
	
	@PostMapping("/add-user")
	public String addBidder(@ModelAttribute("user") User user) {
		userService.createUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/edit-user/{id}")
	public String editUser(Model model, @PathVariable("id") Long user_id) {
		model.addAttribute("user", userService.getUserById(user_id));
		return "edit-user";
	}
	
	@PostMapping("/edit-user/{id}")
	public String updateUserProfile(@PathVariable("id") Long user_id, @ModelAttribute("user") User user) {
		biddingService.updateUserProfile(user_id, user);
		return "redirect:/users";
	}
	
	@GetMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable("id") Long user_id) {
		userService.deleteUser(user_id);
		return "redirect:/users";
	}
	
	@GetMapping("/bid/{id}")
	public String getBidPage(Model model, @PathVariable("id") Long id, @AuthenticationPrincipal CustomUserDetails loggedinUser) {
		Item item = biddingService.getItemById(id);
		model.addAttribute("item", item);
		model.addAttribute("username", loggedinUser.getUsername());
		
		Duration duration = Duration.between(LocalDateTime.now(), item.getEndTime());
		
		if(duration.isNegative()) {
			model.addAttribute("timeleft", null);
		} else {
		model.addAttribute("timeleft", duration.toMinutes());
		}
		
		model.addAttribute("bidder", biddingService.getBidderByItemId(item));
		
		return "bid";
	}
	
	@PostMapping("/bid/{item_id}")
	public String BidItem(@PathVariable("item_id") Long item_id, HttpServletRequest request, @ModelAttribute("bid") Bid bid) {
		String username = request.getParameter("username");
		biddingService.bidItem(item_id, username, bid);
		return "redirect:/auction";
	}
	
	@GetMapping("/delete-item/{item_id}")
	public String deleteItem(@PathVariable("item_id") Long item_id) {
		biddingService.deleteItemByItemId(item_id);
		return "redirect:/items";
	}
	
	@PostMapping("/extend-auction/{item_id}")
	public String extendAuction(@PathVariable("item_id") Long item_id) {
		System.out.println("item_id: " + item_id);
		biddingService.extendAuctionTime(item_id);
		return "redirect:/bid/{item_id}";
	}
	
	@GetMapping("/auction")
	public String getAuctionPage(Model model, @AuthenticationPrincipal CustomUserDetails loggedinUser) {
		List<Item> items = biddingService.getAllItems();		
		model.addAttribute("items", items);
		model.addAttribute("username", loggedinUser.getUsername());
		return "auction";
	}
	
	@GetMapping("/signin")
	public String getSigninPage() {
		return "signin";
	}
}
