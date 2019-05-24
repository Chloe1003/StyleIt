package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Message;
import web.dto.MessageRoom;
import web.service.face.MessageService;

@Controller
public class MessageController {
	
	private static final Logger logger=LoggerFactory.getLogger(MessageController.class);
	
	@Autowired MessageService mServ;
	// 메시지 보냄
	@RequestMapping(value="/message/insertmr", method = RequestMethod.POST)
	public String msgRoomList(HttpSession session, Model model,  int m_no, Message m) {
		
		MessageRoom mr = new MessageRoom();
		int mm_no =(int) session.getAttribute("m_no");
		mr.setParticipant1(mm_no);
		mr.setParticipant2(m_no);
		
		int cnt = mServ.countChat(mr);
		
		if(cnt ==0) {
		
		int mr_no = mServ.dualNo();
		mr.setMr_no(mr_no);
		mServ.MakeMroom(mr);
		//방번호 세션에 저장
		session.setAttribute("mr_no", mr_no);
		
		m.setMr_no(mr_no);
		m.setSender_no(mm_no);
		m.setReceiver_no(m_no);
		mServ.sendMassege(m);
		
		Map map = new HashMap();
		map.put("m_no", m_no);
		model.addAllAttributes(map);

		return "jsonView";
		
		}else {
			
			int mr_no = mServ.getMr_no(mr);
			
//			세션정보 저장
			session.setAttribute("mr_no", mr_no);
			
			System.out.println("메시지 보낼때 번호"+mr_no);
			m.setMr_no(mr_no);
			m.setSender_no(mm_no);
			m.setReceiver_no(m_no);
			
			System.out.println(m);
			mServ.sendMassege(m);
			Map map = new HashMap();
			map.put("m_no", m_no);
			model.addAllAttributes(map);
			
			
			return "jsonView";
		}
	}
		@RequestMapping(value = "/message/Mr_no", method = RequestMethod.GET)
		public String getMr_no(HttpSession session, Model model, int m_no, int mr_no, Message message) {
			
			MessageRoom mr = new MessageRoom();
			int mm_no =(int) session.getAttribute("m_no");
			mr.setParticipant1(mm_no);
			mr.setParticipant2(m_no);
			
			session.setAttribute("mr_no", mr_no);
				
			System.out.println("sesssion"+mm_no);
			System.out.println("대상? "+m_no);
			
				List<Message> MessageList = mServ.MessageList(mr_no);
				model.addAttribute("MessageList", MessageList);
				
				mServ.countUpdate(message);
				
			Map map = new HashMap();
			map.put("m_no", m_no);
			map.put("mr_no", mr_no);
			map.put("MessageList", MessageList);
			model.addAllAttributes(map);
			
			
			return "jsonView";
		}
		
		
	
	
	
	
	
}
