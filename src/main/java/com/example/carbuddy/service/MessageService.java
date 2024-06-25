package com.example.carbuddy.service;

import java.time.LocalDateTime;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carbuddy.entity.Message;
import com.example.carbuddy.repository.MessageRepository;

@Service
@Transactional
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public void saveMessage(Message msg) {
		System.err.println(msg.getSender());
		System.err.println(msg.getEmail());
		System.err.println(msg.getMessage());
		System.err.println(msg.getTimestamp());
		msg.setTimestamp(LocalDateTime.now()); // timestamp
		messageRepository.save(msg);
	}

}
