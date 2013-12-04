package cz.jiripinkas.example.chat.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.jiripinkas.example.chat.dto.ChatroomDto;
import cz.jiripinkas.example.chat.entity.Chatmessage;
import cz.jiripinkas.example.chat.entity.Chatroom;
import cz.jiripinkas.example.chat.service.ChatroomService;

@Controller
@RequestMapping("/chatroom")
public class ChatroomController {

	@Autowired
	private ChatroomService chatroomService;

	@RequestMapping
	public String show() {
		return "chatroom";
	}

	@RequestMapping("/detail/{id}")
	@ResponseBody
	public ChatroomDto restDetail(@PathVariable int id) {
		return chatroomService.getSingleChatroomDto(id);
	}

	@RequestMapping("/csv")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.getWriter().write("csv,works");
	}

	@ModelAttribute("chatroom")
	public Chatroom create() {
		Chatroom chatroom = new Chatroom();
		return chatroom;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid Chatroom chatroom,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "chatroom";
		}
		chatroomService.save(chatroom);
		return "redirect:/chatroom.html?success=true";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("chatrooms", chatroomService.list());
		return "list";
	}

	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam int id) {
		Chatroom chatroom = chatroomService.single(id);
		model.addAttribute("chatroom", chatroom);
		return "detail";
	}

	@RequestMapping("/remove")
	public String remove(Model model, @RequestParam int id) {
		chatroomService.delete(id);
		return "redirect:/chatroom/list.html";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public String saveMessage(@RequestParam String message, @RequestParam int id) {
		Chatmessage chatMessage = new Chatmessage();
		chatMessage.setMessage(message);
		chatroomService.saveChatMessage(chatMessage, id);
		return "redirect:/chatroom/detail.html?id=" + id;
	}
}
