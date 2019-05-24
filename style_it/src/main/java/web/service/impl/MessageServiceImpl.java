package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MessageDao;
import web.dto.Message;
import web.dto.MessageRoom;
import web.service.face.MessageService;
@Service
public class MessageServiceImpl implements MessageService{
@Autowired MessageDao mDao;
	
	
	@Override
	public int dualNo() {
		return mDao.dualNo();
	}


	@Override
	public void MakeMroom(MessageRoom mr) {
		mDao.MakeMroom(mr);
	}


	@Override
	public void sendMassege(Message m) {
		mDao.sendMassege(m);
	}


	@Override
	public int countChat(MessageRoom mr) {
		return mDao.countChat(mr);
	}


	@Override
	public int getMr_no(MessageRoom mr) {
		return mDao.getMr_no(mr);
	}


	@Override
	public List<Message> MessageList(int mr_no) {
		return mDao.MessageList(mr_no);
	}


	@Override
	public List<MessageRoom> getmrList(int m_no) {
		return mDao.getmrList(m_no);
	}


	@Override
	public void countUpdate(Message message) {
		mDao.countUpdate(message);
	}


	@Override
	public int getNotRead(int mr_no, int m_no1) {
		return mDao.getNotRead(mr_no, m_no1);
	}

}
