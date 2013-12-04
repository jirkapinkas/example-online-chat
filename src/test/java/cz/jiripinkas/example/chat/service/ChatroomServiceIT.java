package cz.jiripinkas.example.chat.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.example.chat.entity.Chatroom;
import cz.jiripinkas.example.chat.service.ChatroomService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
@Transactional
public class ChatroomServiceIT {

	@Autowired
	private ChatroomService chatroomService;

	@Test
	public void testSave() {
		int size = chatroomService.list().size();
		Chatroom chatroom = new Chatroom();
		chatroomService.save(chatroom);
		assertEquals(size + 1, chatroomService.list().size());
	}

}
