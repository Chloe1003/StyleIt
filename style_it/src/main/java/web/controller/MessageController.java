package web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.dto.Message;
import web.service.face.MessageService;

@Controller
public class MessageController {
	
	public MessageService mServ;
	private static final Logger logger=LoggerFactory.getLogger(MessageController.class);
	
	// 메시지 방 리스트 반환
	@RequestMapping(value="/message/roomlist")
	public void msgRoomList(HttpSession session, Model model) {
	
	}
	
	// 메시지 리스트 반환
	@RequestMapping(value="/message/list")
	public void msgList(int mr_no, Model model) {
	
	}
	
	// 메시지 보내기
	@RequestMapping(value="/message/send")
	public void msgsend(Message msg) {
	
	}
}
