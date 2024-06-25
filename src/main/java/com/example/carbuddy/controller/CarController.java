package com.example.carbuddy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.carbuddy.entity.Car;
import com.example.carbuddy.service.CarService;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;

	@PostMapping("/search")
	public String searchCar(HttpServletRequest request, Model model) {
		String query = request.getParameter("keyword");
		List<Car> cars = carService.searchCars(query);
		model.addAttribute("cars", cars);
		return "cars";
	}
}
