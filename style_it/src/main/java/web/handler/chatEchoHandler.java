package web.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.dto.Member;
import web.dto.Message;



public class chatEchoHandler extends TextWebSocketHandler{
   private Logger logger = LoggerFactory.getLogger(chatEchoHandler.class);

    ObjectMapper objectMapper = new ObjectMapper();
       List<WebSocketSession> list = Collections.synchronizedList(new ArrayList<>());
       Map<WebSocketSession,Integer> mrlist= new HashMap<>();
       // 웹 소켓에 연결될 때 호출되는 메소드
       @Override
       public void afterConnectionEstablished(WebSocketSession session) throws Exception {
           System.out.println("접속===========================");
           System.out.println(session.getId());
           System.out.println("접속===========================");
           list.add(session);
           
           //-----------웹소켓과 연동된 방번호 map에 저장------------------------
           //웹소켓과 연동된 httpsession정보 얻기 - 정보 가져오기.
           Map<String, Object> httpSession = session.getAttributes();
           int mr_no = (int) httpSession.get("mr_no");
           System.out.println("========================="+mr_no);
           mrlist.put(session, mr_no);
           
           //확인
           System.out.println("방에 접속===========================");
           System.out.println(mrlist);
           System.out.println("=================================");
           //---------------------------------------------------------
           
           
              
           }

       // 메시지를 전송받았을때 호출되는 메소드
       @Override
       protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
           System.out.println("메시지가 왔어요...");
           System.out.println(session.getId() + ", " + message.getPayload());
           System.out.println("메시지가 왔어요...");
           
          //현재 HttpSession의 id얻기
         String m_nick = getId(session);
         String fu_storedname = getUserImg(session);
         Message clientMessage = objectMapper.readValue(message.getPayload(), Message.class);
          
          
         Message chatMessage = new Message();
         
           chatMessage.setM_nick(m_nick);
           chatMessage.setFu_storedname(fu_storedname);
           chatMessage.setMsg_content(clientMessage.getMsg_content());
           
           String json = objectMapper.writeValueAsString(chatMessage);
           
           //현재 websocket의 방번호
           Map<String, Object> httpSession = session.getAttributes();
           int mr_no = (int) httpSession.get("mr_no");
           
           for(WebSocketSession wss : list){
  
        	   Map<String, Object> httpSession2 = wss.getAttributes();
               int mr_no2 = (int) httpSession2.get("mr_no");
        	   if(mr_no==mr_no2) {
        		   wss.sendMessage(new TextMessage(json));
        	   }
        	   
              
           }
       }

       // 웹 소켓이 연결이 클로즈될때 호출되는 메소드
       @Override
       public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
           System.out.println("접속 close===========================");
           System.out.println(session.getId());
           System.out.println("접속 close===========================");
          
           list.remove(session);
           mrlist.remove(session);
   
       }
      private String getId(WebSocketSession session) {
    	  //웹소켓과 연동된 httpsession정보 얻기
         Map<String, Object> httpSession = session.getAttributes();
         
         String loginUser = (String) httpSession.get("m_nick");
         System.out.println("ㅇㅇㅇ"+loginUser);
         
         
         if(null == loginUser) {
         
            return null;
         }else {
         
            return loginUser;
         }
         
      }
      private String getUserImg(WebSocketSession session) {
    	  
    	  Map<String, Object> httpSession = session.getAttributes();
    	  
    	  String imgUser = (String) httpSession.get("fu_storedname");
    	  System.out.println("----img---- : "+ imgUser);
    	  
    	  return imgUser;
      }

}