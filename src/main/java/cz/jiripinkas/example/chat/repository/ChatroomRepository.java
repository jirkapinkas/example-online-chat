package cz.jiripinkas.example.chat.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cz.jiripinkas.example.chat.entity.Chatmessage;
import cz.jiripinkas.example.chat.entity.Chatroom;

@Repository
public class ChatroomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Chatroom> list() {
		return entityManager
				.createNamedQuery(Chatroom.FIND_ALL, Chatroom.class)
				.getResultList();
	}

	public Chatroom single(int id) {
//		return entityManager
//				.createNamedQuery(Chatroom.FIND_ONE, Chatroom.class)
//				.setParameter("id", id).getSingleResult();
		return entityManager.find(Chatroom.class, id);
	}

	public void delete(int id) {
		entityManager.remove(entityManager.find(Chatroom.class, id));
	}

	public void save(Chatroom chatroom) {
		if (chatroom.getId() == 0) {
			entityManager.persist(chatroom);
		} else {
			entityManager.merge(chatroom);
		}
	}

	public void saveMessage(Chatmessage chatMessage) {
		entityManager.persist(chatMessage);
	}

	public void deleteAll() {
		entityManager.createNativeQuery("delete from chatmessage")
				.executeUpdate();
		entityManager.createNativeQuery("delete from chatroom").executeUpdate();
	}

}
