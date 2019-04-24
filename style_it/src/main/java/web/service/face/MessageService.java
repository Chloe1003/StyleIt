package web.service.face;
import java.util.List;

import web.dto.Message;
import web.dto.MessageRoom;

public interface MessageService {
	
	// 메시지 방 리스트 반환
	public List<MessageRoom> getRoomList(int m_no);
	
	// 메시지 리스트 반환
	public List<Message> getMsgList(int mr_no);
	
	// 메시지 보내기
	public void sendMsg(Message msg);
}
