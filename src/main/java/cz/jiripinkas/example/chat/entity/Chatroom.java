package cz.jiripinkas.example.chat.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
		@NamedQuery(name = Chatroom.FIND_ALL, query = "select c from Chatroom c order by c.id"),
		@NamedQuery(name = Chatroom.FIND_ONE, query = "select c from Chatroom c left join fetch c.chatmessages where c.id = :id") })
public class Chatroom {

	public static final String FIND_ALL = "Chatroom.findAll";

	public static final String FIND_ONE = "Chatroom.findOne";

	@Id
	@GeneratedValue
	private int id;

	@Size(min = 1, message = "Name must not be empty!")
	private String name;

	private String description;

	@OrderBy("id desc")
	@OneToMany(mappedBy = "chatroom", cascade= CascadeType.REMOVE)
	private List<Chatmessage> chatmessages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Chatmessage> getChatmessages() {
		return chatmessages;
	}

	public void setChatmessages(List<Chatmessage> chatmessages) {
		this.chatmessages = chatmessages;
	}

}
