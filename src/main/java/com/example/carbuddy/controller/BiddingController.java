package com.example.carbuddy.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.carbuddy.entity.Bid;
import com.example.carbuddy.entity.Car;
import com.example.carbuddy.entity.Item;
import com.example.carbuddy.entity.Message;
import com.example.carbuddy.entity.Role;
import com.example.carbuddy.entity.User;
import com.example.carbuddy.repository.RoleRepository;
import com.example.carbuddy.service.BiddingService;
import com.example.carbuddy.service.CarService;
import com.example.carbuddy.service.CustomUserDetails;
import com.example.carbuddy.service.ItemService;
import com.example.carbuddy.service.MessageService;
import com.example.carbuddy.service.UserService;

@Controller
public class BiddingController {
	
	@Autowired 
	private BiddingService biddingService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private RoleRepository roleRepository;

	@GetMapping("/items")
	public String getItemsPage(Model model,
			@AuthenticationPrincipal CustomUserDetails loggedinUser) {
		List<Item> items = userService.getAllItemsByUsername(loggedinUser.getUsername());
		model.addAttribute("items", items);
		return "items";
	}
	
	@GetMapping("/add-item")
	public String addItemPage() {
		return "add-item";
	}
	
	@PostMapping("/add-item")
	public String addItem(@ModelAttribute("item") Item item,
			@AuthenticationPrincipal CustomUserDetails loggedinUser) {
		itemService.addItem(item, loggedinUser.getUsername());
		return "redirect:/items";
	}
	
	@GetMapping("/edit-item/{id}")
	public String editItemPage(@PathVariable("id") Long id, 
			Model model) {
		model.addAttribute("item", biddingService.getItemById(id));
		return "edit-item";
	}
	
	@PostMapping("/update-item/{id}")
	public String updateItem(@PathVariable("id") Long id, 
			@ModelAttribute("item") Item item) {
		biddingService.updateItem(id, item);
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
	public String updateUserProfile(@PathVariable("id") Long user_id, 
			@ModelAttribute("user") User user,
			@ModelAttribute("role_admin") String role_admin) {
		
		userService.updateUser(user_id, user, role_admin);
		return "redirect:/users";
	}
	
	@GetMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable("id") Long user_id) {
		userService.deleteUser(user_id);
		return "redirect:/users";
	}
	
	@GetMapping("/bid/{id}")
	public String getBidPage(Model model, @PathVariable("id") Long id, 
			@AuthenticationPrincipal CustomUserDetails loggedinUser) {
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
	
	@PostMapping("/bid/{item_id}/{username}")
	public String BidItem(@PathVariable("item_id") Long item_id, 
			@PathVariable("username") String username, 
			@ModelAttribute("bid") Bid bid) {

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
	
	@GetMapping("/login")
	public String getSigninPage() {
		return "signin";
	}
	
	@GetMapping("/")
	public String getHomepage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String getSignupPage() {
		return "register";
	}
	
	@PostMapping("/register/new")
	public String processSignup(@ModelAttribute("user") User user,
			RedirectAttributes redirectAttributes) {
		if(userService.getUserByEmail(user.getEmail()) == null) {
			userService.createUser(user);
			redirectAttributes.addFlashAttribute("str_success", "Account is created. Please proceed with sign in.");
			return "redirect:/signin";
		} else {
			redirectAttributes.addFlashAttribute("str_err", "User already exists! Login '<a href='/signin'>here</a>'");
			return "redirect:/signup";
		}
	}
	
	@GetMapping("/dashboard")
	public String getAdminDashboard(Model model) {
		model.addAttribute("items", itemService.getAllItems());
		model.addAttribute("users", userService.getAllUsers());
		return "dashboard";
	}
	
	@GetMapping("/cars")
	public String getCarsPage(Model model) {
		List<Car> cars = carService.getAllCars();
		model.addAttribute("cars", cars);
		return "cars";
	}
	
	@GetMapping("/cars/new")
	public String addCarPage() {
		return "addCar";
	}
	
	@PostMapping("/cars/new")
	public String processAddCar(@ModelAttribute("car") Car car, Model model) {
		carService.create(car);
		return "redirect:/cars";
	}
	
	@GetMapping("/about")
	public String getAboutPage() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String getContactPage() {
		return "contact";
	}
	
	@PostMapping("/contact")
	public String processMessage(@ModelAttribute("message") Message msg) {
		System.err.println(msg.getSender());
		System.err.println(msg.getEmail());
		System.err.println(msg.getMessage());
		System.err.println(msg.getTimestamp());
		messageService.saveMessage(msg);
		return "redirect:/";
	}
}
