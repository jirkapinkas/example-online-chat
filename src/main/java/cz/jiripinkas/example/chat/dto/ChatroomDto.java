package cz.jiripinkas.example.chat.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChatroomDto {

	private String name;
	
	private int id;
	
	private List<ChatmessageDto> chatmessages;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ChatmessageDto> getChatmessages() {
		return chatmessages;
	}

	public void setChatmessages(List<ChatmessageDto> chatmessages) {
		this.chatmessages = chatmessages;
	}
	
	
}
