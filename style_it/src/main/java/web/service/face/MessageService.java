package web.service.face;
import java.util.List;

import web.dto.Message;
import web.dto.MessageRoom;

public interface MessageService {
	
	public int dualNo();

	public void MakeMroom(MessageRoom mr);

	public void sendMassege(Message m);

	public int countChat(MessageRoom mr);

	public int getMr_no(MessageRoom mr);

	public List<Message> MessageList(int mr_no);

	public List<MessageRoom> getmrList(int m_no);

	public void countUpdate(Message message);

	public int getNotRead(int mr_no, int m_no1);
}
