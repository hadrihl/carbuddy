package com.example.carbuddy.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.carbuddy.entity.Message;
import com.example.carbuddy.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@GetMapping("/contact")
	public String getContactPage() {
		return "contact";
	}
	
	@PostMapping("/contact")
	public String processMessage(@ModelAttribute("message") Message msg,
			@RequestParam("textmessage") String textmessage) {
		messageService.saveMessage(msg, textmessage);
		return "redirect:/";
	}
}
