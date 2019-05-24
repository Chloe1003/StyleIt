package web.dao.face;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import web.dto.Message;
import web.dto.MessageRoom;

public interface MessageDao {
	
	public int dualNo();

	public void MakeMroom(MessageRoom mr);

	public void sendMassege(Message m);

	public int countChat(MessageRoom mr);

	public int getMr_no(MessageRoom mr);

	public List<Message> MessageList(int mr_no);

	public List<MessageRoom> getmrList(int m_no);

	public void countUpdate(Message message);

	public int getNotRead(@Param("mr_no") int mr_no, @Param("m_no1") int m_no1);
	
	
}
