package cz.java.skoleni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cz.java.skoleni.annotation.TransactionalRW;
import cz.java.skoleni.entity.Chatroom;

@Service
public class InitDbService {

	@Autowired
	private ChatroomService chatroomService;

	@TransactionalRW
	// @PostConstruct
	// initialize database each day
	@Scheduled(fixedDelay = 86400000)
	public void init() {
		System.out.println("*** START INIT DATABASE ***");
		chatroomService.deleteAll();
		{
			Chatroom chatroom = new Chatroom();
			chatroom.setName("Soccer");
			chatroom.setDescription("The most popular game on Earth!");
			chatroomService.save(chatroom);
		}

		{
			Chatroom chatroom = new Chatroom();
			chatroom.setName("Programmers");
			chatroom.setDescription("How to code like a pro :)");
			chatroomService.save(chatroom);
		}

		{
			Chatroom chatroom = new Chatroom();
			chatroom.setName("Justin Bieber");
			chatroom.setDescription("Is it a boy or a woman?");
			chatroomService.save(chatroom);
		}
		System.out.println("*** FINISH INIT DATABASE ***");
	}
}
