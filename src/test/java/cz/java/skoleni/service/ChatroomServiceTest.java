package cz.java.skoleni.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cz.java.skoleni.entity.Chatroom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
@Transactional
public class ChatroomServiceTest {

	@Autowired
	private ChatroomService chatroomService;

	@Test
	public void testSave() {
		Chatroom chatroom = new Chatroom();
		chatroomService.save(chatroom);
	}

}
