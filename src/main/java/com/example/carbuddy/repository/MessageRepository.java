package com.example.carbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carbuddy.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
