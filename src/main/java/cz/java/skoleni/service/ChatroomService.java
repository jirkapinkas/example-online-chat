package cz.java.skoleni.service;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.java.skoleni.annotation.TransactionalRO;
import cz.java.skoleni.annotation.TransactionalRW;
import cz.java.skoleni.dto.ChatroomDto;
import cz.java.skoleni.entity.Chatmessage;
import cz.java.skoleni.entity.Chatroom;
import cz.java.skoleni.repository.ChatroomRepository;

@TransactionalRO
@Service
public class ChatroomService {

	@Autowired
	private ChatroomRepository chatroomRepository;

	public List<Chatroom> list() {
		return chatroomRepository.list();
	}

	public Chatroom single(int id) {
		return chatroomRepository.single(id);
	}

	public ChatroomDto getSingleChatroomDto(int id) {
		Chatroom chatroom = chatroomRepository.single(id);
		Mapper mapper = new DozerBeanMapper();
		return mapper.map(chatroom, ChatroomDto.class);
	}

	@TransactionalRW
	public void delete(int id) {
		chatroomRepository.delete(id);
	}

	@TransactionalRW
	public void save(Chatroom chatroom) {
		chatroomRepository.save(chatroom);
	}

	@TransactionalRW
	public void saveChatMessage(Chatmessage chatMessage, int id) {
		Chatroom chatroom = chatroomRepository.single(id);
		chatMessage.setChatroom(chatroom);
		chatMessage.setAddedDate(new Date());
		chatroomRepository.saveMessage(chatMessage);
	}

	public void deleteAll() {
		chatroomRepository.deleteAll();
	}
}
