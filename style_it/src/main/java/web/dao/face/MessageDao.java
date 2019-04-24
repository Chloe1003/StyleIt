package web.dao.face;

import java.util.List;

import web.dto.Message;
import web.dto.MessageRoom;

public interface MessageDao {
	
	// 메시지 방 리스트 가져오기
	public List<MessageRoom> selectRoomList(int m_no);
	
	// 메시지 리스트 반환
	public List<Message> selectMsgList(int mr_no);
	
	// 메시지 보내기
	public void insertMsg(Message msg);
	
	// 메시지 열람여부 업데이트
	public void updateRead(int msg_no);
}
